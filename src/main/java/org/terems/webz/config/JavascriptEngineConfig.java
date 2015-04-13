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
import java.util.Properties;
import java.util.Set;

import org.terems.webz.WebzDefaults;
import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzProperties;
import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class JavascriptEngineConfig extends WebzConfigObject {

	private Set<String> fileSuffixesLowerCased;
	private boolean processFolders;
	private String pageDefaultMimetype;

	/** TODO !!! describe !!! **/
	public Set<String> getFileSuffixesLowerCased() {
		return fileSuffixesLowerCased;
	}

	/** TODO !!! describe !!! **/
	public boolean getProcessFolders() {
		return processFolders;
	}

	/** TODO !!! describe !!! **/
	public String getPageDefaultMimetype() {
		return pageDefaultMimetype;
	}

	@Override
	public void init(WebzFile configFolder) throws IOException, WebzException {

		WebzFile file = configFolder.getDescendant(WebzProperties.GENERAL_PROPERTIES_FILE);

		Properties properties = new Properties();
		WebzUtils.loadProperties(properties, file, false);

		fileSuffixesLowerCased = WebzUtils.parseCsvAsLowerCasedSet(properties.getProperty(
				WebzProperties.JS_ENGINE_FILTER_FILE_SUFFIXES_PROPERTY, WebzDefaults.JS_ENGINE_FILTER_FILE_SUFFIXES));
		processFolders = Boolean.valueOf(properties.getProperty(WebzProperties.JS_ENGINE_FILTER_PROCESS_FOLDERS_PROPERTY,
				String.valueOf(WebzDefaults.JS_ENGINE_FILTER_PROCESS_FOLDERS)));
		pageDefaultMimetype = properties.getProperty(WebzProperties.JS_ENGINE_FILTER_PAGE_DEFAULT_MIMETYPE_PROPERTY,
				WebzDefaults.JS_ENGINE_FILTER_PAGE_DEFAULT_MIMETYPE);
	}

}
