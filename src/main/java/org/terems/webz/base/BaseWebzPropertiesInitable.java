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

package org.terems.webz.base;

import java.util.Properties;

import org.terems.webz.WebzException;
import org.terems.webz.WebzProperties;
import org.terems.webz.WebzPropertiesInitable;

/** TODO !!! describe !!! **/
public abstract class BaseWebzPropertiesInitable extends BaseWebzDestroyable implements WebzPropertiesInitable {

	private WebzProperties properties;

	/** Do nothing by default... **/
	protected void init() throws WebzException {
	}

	/** TODO !!! describe !!! **/
	protected WebzProperties getProperties() {
		return properties;
	}

	/** TODO !!! describe !!! **/
	@Override
	public final void init(Properties properties) throws WebzException {

		if (properties == null) {
			throw new NullPointerException("null Properties");
		}
		init(new WebzProperties(properties));
	}

	/** TODO !!! describe !!! **/
	@Override
	public final void init(WebzProperties webzProperties) throws WebzException {

		if (webzProperties == null) {
			throw new NullPointerException("null WebzProperties");
		}
		this.properties = webzProperties;
		init();
	}

}
