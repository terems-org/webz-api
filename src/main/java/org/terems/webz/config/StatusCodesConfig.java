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

import java.util.Properties;

import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzProperties;
import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class StatusCodesConfig extends WebzConfigObject {

	private String pathTo404file;
	private String pathTo500file;

	/** TODO !!! describe !!! **/
	public String getPathTo404file() {
		return pathTo404file;
	}

	/** TODO !!! describe !!! **/
	public String getPathTo500file() {
		return pathTo500file;
	}

	@Override
	public void init(WebzFile configFolder) throws WebzException {

		WebzFile file = configFolder.getDescendant(WebzProperties.STATUS_CODES_PROPERTIES_FILE);
		Properties properties = WebzUtils.loadProperties(file, false);

		pathTo404file = properties.getProperty(WebzProperties.PATH_TO_404_FILE_PROPERTY);
		pathTo500file = properties.getProperty(WebzProperties.PATH_TO_500_FILE_PROPERTY);
	}

}
