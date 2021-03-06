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

import javax.servlet.http.HttpServletRequest;

import org.terems.webz.WebzContext;
import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;

/** TODO !!! describe !!! **/
public abstract class WebzContextProxy implements WebzContext {

	/** TODO !!! describe !!! **/
	protected abstract WebzContext getInternalContext();

	@Override
	public WebzFile resolveFile(HttpServletRequest req) throws IOException, WebzException {
		return getInternalContext().resolveFile(req);
	}

	@Override
	public WebzFile getFile(String pathInfo) throws IOException, WebzException {
		return getInternalContext().getFile(pathInfo);
	}

	@Override
	public String resolveUri(WebzFile file, HttpServletRequest req) throws IOException, WebzException {
		return getInternalContext().resolveUri(file, req);
	}

}
