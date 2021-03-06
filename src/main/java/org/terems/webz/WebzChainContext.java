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
public interface WebzChainContext extends WebzContext {

	/** TODO !!! describe !!! **/
	public void nextPlease(HttpServletRequest req, HttpServletResponse resp) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public void nextPlease(HttpServletRequest req, HttpServletResponse resp, WebzContext contextWrapper) throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public void nextPlease(HttpServletRequest req, HttpServletResponse resp, Class<? extends WebzFilter> nextFilter) throws IOException,
			WebzException;

	/** TODO !!! describe !!! **/
	public void nextPlease(HttpServletRequest req, HttpServletResponse resp, WebzContext contextWrapper,
			Class<? extends WebzFilter> nextFilter) throws IOException, WebzException;

}
