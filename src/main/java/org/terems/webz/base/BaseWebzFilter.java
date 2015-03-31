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

import java.io.IOException;

import org.terems.webz.WebzConfig;
import org.terems.webz.WebzContext;
import org.terems.webz.WebzException;
import org.terems.webz.WebzFilter;

/** TODO !!! describe !!! **/
public abstract class BaseWebzFilter implements WebzFilter {

	private WebzConfig appConfig;

	/** TODO !!! describe !!! **/
	public WebzConfig getAppConfig() {
		return appConfig;
	}

	/** Do nothing by default... **/
	public void init(WebzContext context) throws IOException, WebzException {
	}

	/** TODO !!! describe !!! **/
	@Override
	public final void init(WebzConfig appConfig, WebzContext context) throws IOException, WebzException {
		this.appConfig = appConfig;
		init(context);
	}

	/** Do nothing by default... **/
	@Override
	public void destroy() {
	}

}
