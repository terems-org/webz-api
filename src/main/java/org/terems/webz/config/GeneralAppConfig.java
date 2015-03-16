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

package org.terems.webz.config;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Properties;

import org.terems.webz.WebzDefaults;
import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzProperties;
import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class GeneralAppConfig extends WebzConfigObject {

	private String appDisplayName;
	private String defaultMimetype;
	private String defaultEncoding;
	private boolean welcomeRedirectsPermanent;

	private Collection<String> welcomeFilenameSuffixesLowerCased;
	private Collection<String> welcomeFilenamesLowerCased;

	/** TODO !!! describe !!! **/
	public String getAppDisplayName() {
		return appDisplayName;
	}

	/** TODO !!! describe !!! **/
	public String getDefaultMimetype() {
		return defaultMimetype;
	}

	/** TODO !!! describe !!! **/
	public String getDefaultEncoding() {
		return defaultEncoding;
	}

	/** TODO !!! describe !!! **/
	public boolean isWelcomeRedirectsPermanent() {
		return welcomeRedirectsPermanent;
	}

	/** TODO !!! describe !!! **/
	public Collection<String> getWelcomeFilenameSuffixesLowerCased() {
		return welcomeFilenameSuffixesLowerCased;
	}

	/** TODO !!! describe !!! **/
	public Collection<String> getWelcomeFilenamesLowerCased() {
		return welcomeFilenamesLowerCased;
	}

	@Override
	public void init(WebzFile configFolder) throws IOException, WebzException {

		WebzFile file = configFolder.getDescendant(WebzProperties.GENERAL_PROPERTIES_FILE);

		Properties properties = new Properties();
		WebzUtils.loadProperties(properties, file, false);

		appDisplayName = properties.getProperty(WebzProperties.APP_DISPLAY_NAME_PROPERTY);
		defaultMimetype = properties.getProperty(WebzProperties.DEFAULT_MIMETYPE_PROPERTY, WebzDefaults.MIMETYPE);
		defaultEncoding = properties.getProperty(WebzProperties.DEFAULT_ENCODING_PROPERTY, WebzDefaults.UTF8);
		welcomeRedirectsPermanent = Boolean.valueOf(properties.getProperty(WebzProperties.WELCOME_REDIRECTS_PERMANENT_PROPERTY,
				String.valueOf(WebzDefaults.WELCOME_REDIRECTS_PERMANENT)));

		welcomeFilenameSuffixesLowerCased = populateLowerCasedWelcomeItems(properties.getProperty(
				WebzProperties.WELCOME_FILENAME_SUFFIXES_PROPERTY, WebzDefaults.WELCOME_FILENAME_SUFFIXES_LIST));
		welcomeFilenamesLowerCased = populateLowerCasedWelcomeItems(properties.getProperty(WebzProperties.WELCOME_FILENAMES_PROPERTY,
				WebzDefaults.WELCOME_FILENAMES_LIST));
	}

	private Collection<String> populateLowerCasedWelcomeItems(String welcomeItemsCsv) {

		Collection<String> result = new LinkedHashSet<String>();

		for (String item : WebzUtils.parseCsv(welcomeItemsCsv)) {
			result.add(WebzUtils.toLowerCaseEng(item));
		}
		return result;
	}

}
