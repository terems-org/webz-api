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

import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.base.BaseWebzDestroyable;

/** TODO !!! describe !!! **/
public abstract class WebzConfigObject extends BaseWebzDestroyable {

	/** TODO !!! describe !!! **/
	public abstract void init(WebzFile configFolder) throws IOException, WebzException;

	private volatile boolean initialized;
	private final Object mutex = new Object();

	/** TODO !!! describe !!! For internal use only... **/
	public final boolean doOneTimeInit(WebzFile configFolder) throws WebzException {

		if (!initialized) {
			synchronized (mutex) {
				if (!initialized) {

					try {
						init(configFolder);
						initialized = true;
						return true;

					} catch (IOException e) {
						throw new WebzException(e);
					}
				}
			}
		}
		return false;
	}

}
