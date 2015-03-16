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

import org.terems.webz.WebzDefaults;
import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzProperties;
import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class MarkdownForSpaConfig extends WebzConfigObject {

	private String markdownSuffixLowerCased;
	private String mustacheTemplate;
	private String mustacheResultingMimetype;

	/** TODO !!! describe !!! **/
	public String getMarkdownSuffixLowerCased() {
		return markdownSuffixLowerCased;
	}

	/** TODO !!! describe !!! **/
	public String getMustacheTemplate() {
		return mustacheTemplate;
	}

	/** TODO !!! describe !!! **/
	public String getMustacheResultingMimetype() {
		return mustacheResultingMimetype;
	}

	@Override
	public void init(WebzFile configFolder) throws IOException, WebzException {

		WebzFile file = configFolder.getDescendant(WebzProperties.GENERAL_PROPERTIES_FILE);

		Properties properties = new Properties();
		WebzUtils.loadProperties(properties, file, false);

		markdownSuffixLowerCased = WebzUtils.toLowerCaseEng(properties.getProperty(WebzProperties.MARKDOWN_SUFFIX_PROPERTY,
				WebzDefaults.MARKDOWN_SUFFIX));
		mustacheTemplate = properties.getProperty(WebzProperties.MUSTACHE_TEMPLATE_PROPERTY, WebzDefaults.MUSTACHE_TEMPLATE);
		mustacheResultingMimetype = properties.getProperty(WebzProperties.MUSTACHE_RESULTING_MIMETYPE_PROPERTY,
				WebzDefaults.MUSTACHE_RESULTING_MIMETYPE);
	}

}
