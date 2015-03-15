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

import org.terems.webz.WebzDefaults;
import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzProperties;
import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class ForcedRedirectsConfig extends WebzConfigObject {

	private String forcedRedirectsQueryParam;
	private boolean forcedRedirectsPermanent;

	private WebzProperties forcedRedirectsUrlPatterns = new WebzProperties();

	/** TODO !!! describe !!! **/
	public String getForcedRedirectsQueryParam() {
		return forcedRedirectsQueryParam;
	}

	/** TODO !!! describe !!! **/
	public boolean isForcedRedirectsPermanent() {
		return forcedRedirectsPermanent;
	}

	/** TODO !!! describe !!! **/
	public String getForcedRedirectsUrlPattern(String queryParamValue) {
		return forcedRedirectsUrlPatterns.get(queryParamValue);
	}

	@Override
	public void init(WebzFile configFolder) throws WebzException {

		WebzFile file = configFolder.getDescendant(WebzProperties.GENERAL_PROPERTIES_FILE);

		Properties properties = new Properties();
		WebzUtils.loadProperties(properties, file, false);

		forcedRedirectsQueryParam = properties.getProperty(WebzProperties.FORCED_REDIRECTS_QUERY_PARAM_PROPERTY);
		forcedRedirectsPermanent = Boolean.valueOf(properties.getProperty(WebzProperties.FORCED_REDIRECTS_PERMANENT_PROPERTY,
				String.valueOf(WebzDefaults.FORCED_REDIRECTS_PERMANENT)));

		for (Map.Entry<Object, Object> entry : properties.entrySet()) {

			String key = WebzUtils.assertString(entry.getKey());
			if (key.startsWith(WebzProperties.FORCED_REDIRECTS_URL_PATTERN_FOR_PROPERTY_PREFIX)) {

				key = key.substring(WebzProperties.FORCED_REDIRECTS_URL_PATTERN_FOR_PROPERTY_PREFIX.length());
				forcedRedirectsUrlPatterns.put(key, WebzUtils.assertString(entry.getValue()));
			}
		}
	}

}
