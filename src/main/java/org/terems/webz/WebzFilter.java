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

package org.terems.webz;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** TODO !!! describe !!! **/
public interface WebzFilter extends WebzDestroyable {

	/** TODO !!! describe !!! **/
	public void init(WebzConfig appConfig) throws WebzException;

	/** TODO !!! describe !!! **/
	public void serve(HttpServletRequest req, HttpServletResponse resp, WebzChainContext chainContext) throws IOException, WebzException;

	public static final String HTTP_GET = "GET";
	public static final String HTTP_POST = "POST";
	public static final String HTTP_PUT = "PUT";
	public static final String HTTP_DELETE = "DELETE";
	public static final String HTTP_HEAD = "HEAD";
	public static final String HTTP_TRACE = "TRACE";
	public static final String HTTP_OPTIONS = "OPTIONS";

	public static final String HEADER_LOCATION = "Location";

	public static final String HEADER_LAST_MODIFIED = "Last-Modified";
	public static final String HEADER_IF_MODIFIED_SINCE = "If-Modified-Since";
	public static final String HEADER_CONTENT_LENGTH = "Content-Length";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";

}
