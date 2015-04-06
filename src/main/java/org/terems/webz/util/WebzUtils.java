/*
 * Copyright 2014-2015 Oleksandr Tereschenko <http://www.terems.org/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terems.webz.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzFilter;
import org.terems.webz.WebzIdentifiable;
import org.terems.webz.WebzMetadata;
import org.terems.webz.WebzProperties;
import org.terems.webz.WebzReadException;
import org.terems.webz.WebzReaderDownloader;
import org.terems.webz.WebzWriteException;
import org.terems.webz.base.BaseWebzFilter;

/** TODO !!! describe !!! **/
public class WebzUtils {

	public static final char FILE_EXT_SEPARATOR = '.';

	private static final int DEFAULT_BUFFER_SIZE = 8192;

	/** TODO !!! describe !!! **/
	public static String getFullUrl(HttpServletRequest req) {

		StringBuffer requestUrl = req.getRequestURL();
		String queryString = req.getQueryString();

		if (queryString == null) {
			return requestUrl.toString();
		} else {
			return requestUrl.append('?').append(queryString).toString();
		}
	}

	/** TODO !!! describe !!! **/
	public static String formatRequestMethodAndUrl(HttpServletRequest req) {
		return req.getMethod() + " " + getFullUrl(req);
	}

	/** TODO !!! describe !!! **/
	public static long copyInToOut(InputStream in, OutputStream out) throws WebzReadException, WebzWriteException {

		long bytesTotal = 0;

		byte[] buff = new byte[DEFAULT_BUFFER_SIZE];

		while (true) {
			int bytes;

			try {
				bytes = in.read(buff);
			} catch (IOException e) {
				throw new WebzReadException(e);
			}

			if (bytes < 1) {
				break;
			}

			try {
				out.write(buff, 0, bytes);
			} catch (IOException e) {
				throw new WebzWriteException(e);
			}

			bytesTotal += bytes;
		}

		return bytesTotal;
	}

	/** TODO !!! describe !!! **/
	public static long copyReaderToWriter(Reader reader, Writer writer) throws WebzReadException, WebzWriteException {

		long charsTotal = 0;

		char[] buff = new char[DEFAULT_BUFFER_SIZE];

		while (true) {
			int chars;

			try {
				chars = reader.read(buff);
			} catch (IOException e) {
				throw new WebzReadException(e);
			}

			if (chars < 1) {
				break;
			}

			try {
				writer.write(buff, 0, chars);
			} catch (IOException e) {
				throw new WebzWriteException(e);
			}

			charsTotal += chars;
		}

		return charsTotal;
	}

	/** TODO !!! describe !!! **/
	public static void closeSafely(Closeable resource) {

		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				// ignore
			}
		}
	}

	/** TODO !!! describe !!! **/
	public static boolean containsUpperCaseLetters(String value) {

		int len = value.length();
		for (int i = 0; i < len;) {

			int codePoint = value.codePointAt(i);
			if (Character.isUpperCase(codePoint)) {
				return true;
			}

			i += Character.charCount(codePoint);
		}

		return false;
	}

	private static final ClassLoader DEFAULT_CLASS_LOADER = WebzUtils.class.getClassLoader();

	/** TODO !!! describe !!! **/
	public static boolean loadPropertiesFromClasspath(Properties properties, String resourceName, boolean failIfNotFound)
			throws IOException, WebzException {
		return loadPropertiesFromClasspath(properties, resourceName, DEFAULT_CLASS_LOADER, failIfNotFound);
	}

	/** TODO !!! describe !!! **/
	public static boolean loadPropertiesFromClasspath(Properties properties, String resourceName, ClassLoader classLoader,
			boolean failIfNotFound) throws IOException, WebzException {

		if (resourceName == null) {
			throw new NullPointerException("null resource name was supplied - properties cannot be read");
		}

		InputStream in = classLoader.getResourceAsStream(resourceName);
		try {
			if (in == null) {
				if (failIfNotFound) {
					throw new WebzException("'" + resourceName + "' was not found on classpath");
				}
				return false;
			}
			properties.load(in);

		} finally {
			closeSafely(in);
		}
		return true;
	}

	/** TODO !!! describe !!! **/
	public static boolean loadProperties(Properties properties, WebzFile file, boolean failIfNotFound) throws IOException, WebzException {

		if (file == null) {
			throw new NullPointerException("null WebzFile was supplied - properties cannot be read");
		}

		WebzReaderDownloader downloader = null;
		try {
			downloader = file.getFileDownloader();

			if (downloader == null) {
				if (failIfNotFound) {
					throw new WebzException("'" + file.getPathname() + "' was not found");
				}
				return false;
			}
			properties.load(downloader.getReader());

		} finally {
			if (downloader != null) {
				downloader.close();
			}
		}
		return true;
	}

	/** TODO !!! describe !!! **/
	public static String getFileExtension(WebzMetadata metadata) throws IOException, WebzException {

		if (metadata != null) {
			String fileName = metadata.getName();
			int i = fileName.lastIndexOf(FILE_EXT_SEPARATOR);

			if (i > -1) {
				return fileName.substring(i + 1);
			}
		}
		return null;
	}

	/** TODO !!! describe !!! **/
	public static String assertString(Object value) {

		if (!(value instanceof String)) {
			throw new ClassCastException(value + " is not of type String");
		}
		return (String) value;
	}

	/** TODO !!! describe !!! **/
	public static <T> T assertNotNull(T value) {

		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}

	private static final String WEBZ_FILE_SYSTEM_ID_MSG = "WebzFileSystem ID";

	/** TODO !!! describe !!! **/
	public static String formatFileSystemMessage(String message, WebzIdentifiable identifiable) {
		return message + " (" + WEBZ_FILE_SYSTEM_ID_MSG + ": '" + identifiable.getUniqueId() + "')";
	}

	/** TODO !!! describe !!! **/
	public static String formatFileSystemMessageNoBrackets(String message, WebzIdentifiable identifiable) {
		return message + " - " + WEBZ_FILE_SYSTEM_ID_MSG + ": '" + identifiable.getUniqueId() + "'";
	}

	/** TODO !!! describe !!! **/
	public static String replaceWhitespacesWithDashesSafely(String value) {

		if (value == null) {
			return null;
		}
		return value.trim().replaceAll("\\s+", "-");
	}

	private static final ThreadLocal<DateFormat> HTTP_DATE_FORMAT = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			DateFormat value = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss.SSS z", Locale.US);
			value.setTimeZone(TimeZone.getTimeZone("GMT"));
			return value;
		}
	};

	/** TODO !!! describe !!! **/
	public static String formatHttpDate(long date) {
		return formatHttpDate(new Date(date));
	}

	/** TODO !!! describe !!! **/
	public static String formatHttpDate(Date date) {
		return HTTP_DATE_FORMAT.get().format(date);
	}

	/** TODO !!! describe !!! **/
	public static String[] parseCsv(String csv) {

		if (csv == null) {
			return new String[] {};
		}
		// TODO support proper csv unescaping
		return csv.split("\\s*,\\s*");
	}

	/** TODO !!! describe !!! **/
	public static Set<String> parseCsvAsLowerCasedSet(String csv) {

		Set<String> result = new LinkedHashSet<String>();

		for (String item : parseCsv(csv)) {
			result.add(toLowerCaseEng(item));
		}
		return result;
	}

	/** TODO !!! describe !!! **/
	public static boolean isHttpMethodHead(HttpServletRequest req) {
		return BaseWebzFilter.HTTP_HEAD.equals(req.getMethod());
	}

	/** TODO !!! describe !!! **/
	public static boolean isHttpMethodGet(HttpServletRequest req) {
		return BaseWebzFilter.HTTP_GET.equals(req.getMethod());
	}

	/** TODO !!! describe !!! **/
	public static void prepareStandardHeaders(HttpServletResponse resp, String contentType, String characterEncoding, long contentLength) {

		resp.setContentType(contentType);
		resp.setCharacterEncoding(characterEncoding);

		resp.addHeader("Content-Length", Long.toString(contentLength));
		// with Servlet API 3.1 it could be: resp.setContentLengthLong(contentLength);
	}

	/** TODO !!! describe !!! **/
	public static void doRedirect(HttpServletResponse resp, String redirectUrl, boolean permanent, boolean methodHead) throws IOException {

		resp.setStatus(permanent ? HttpServletResponse.SC_MOVED_PERMANENTLY : HttpServletResponse.SC_MOVED_TEMPORARILY);
		resp.setHeader(WebzFilter.HEADER_LOCATION, redirectUrl);

		if (!methodHead) {
			resp.getWriter().write("Redirect to " + redirectUrl);
		}
		resp.flushBuffer();
	}

	/** TODO !!! describe !!! **/
	public static String fetchLocalStorageBasePath(WebzProperties properties) {

		String localStorageBasePathEnvVar = properties.get(WebzProperties.LOCAL_STORAGE_BASE_PATH_ENV_VAR_PROPERTY);
		return localStorageBasePathEnvVar == null ? properties.get(WebzProperties.LOCAL_STORAGE_BASE_PATH_PROPERTY) : System
				.getenv(localStorageBasePathEnvVar);
	}

	/** TODO !!! describe !!! **/
	public static String toLowerCaseEng(String value) {

		if (value == null) {
			return null;
		}
		return value.toLowerCase(Locale.ENGLISH);
	}

}
