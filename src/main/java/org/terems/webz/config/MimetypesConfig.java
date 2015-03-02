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

import java.util.Map;
import java.util.Properties;

import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzMetadata;
import org.terems.webz.WebzProperties;
import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class MimetypesConfig extends WebzConfigObject {

	private static final String MIMETYPES_PROPERTIES_RESOURCE = WebzProperties.MIMETYPES_PROPERTIES_FILE;

	private WebzProperties mimetypes = new WebzProperties();

	/** TODO !!! describe !!! **/
	public String getMimetype(WebzMetadata metadata, String defaultMimetype) throws WebzException {

		String fileExtension = WebzUtils.getFileExtension(metadata);

		if (fileExtension == null) {
			return defaultMimetype;
		}
		return mimetypes.get(WebzUtils.toLowerCaseEng(fileExtension), defaultMimetype);
	}

	@Override
	public void init(WebzFile configFolder) throws WebzException {

		WebzFile file = configFolder.getDescendant(WebzProperties.MIMETYPES_PROPERTIES_FILE);

		Properties mimetypesProperties = new Properties();

		WebzUtils.loadPropertiesFromClasspath(mimetypesProperties, MIMETYPES_PROPERTIES_RESOURCE, true);
		WebzUtils.loadProperties(mimetypesProperties, file, false);

		for (Map.Entry<Object, Object> entry : mimetypesProperties.entrySet()) {
			mimetypes.put(WebzUtils.toLowerCaseEng(WebzUtils.assertString(entry.getKey())), WebzUtils.assertString(entry.getValue()));
		}
	}

}
