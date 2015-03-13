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

import org.terems.webz.WebzException;
import org.terems.webz.WebzMetadata;

/** TODO !!! describe !!! **/
public abstract class BaseWebzMetadata implements WebzMetadata, WebzMetadata.FileSpecific {

	/** TODO !!! describe !!! **/
	@Override
	public String getLinkedPathname() {
		return null;
	}

	/** TODO !!! describe !!! **/
	@Override
	public String getFileSourceType() {
		return FILE_SOURCE_TYPE_UNDEFINED;
	}

	/** TODO !!! describe !!! **/
	@Override
	public FileSpecific getFileSpecific() throws IOException, WebzException {
		return isFile() ? this : null;
	}

}
