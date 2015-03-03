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

import java.io.InputStream;
import java.io.OutputStream;

import org.terems.webz.util.WebzUtils;

/** TODO !!! describe !!! **/
public class WebzFileDownloader {

	/** TODO !!! describe !!! **/
	public WebzMetadata.FileSpecific fileSpecific;

	/** TODO !!! describe !!! **/
	public final InputStream content;

	/** TODO !!! describe !!! **/
	public long copyContentAndClose(OutputStream out) throws WebzReadException, WebzWriteException {

		try {
			return WebzUtils.copyInToOut(content, out);
		} finally {
			close();
		}
	}

	/** TODO !!! describe !!! **/
	public void close() {
		WebzUtils.closeSafely(content);
	}

	/** TODO !!! describe !!! **/
	public WebzFileDownloader(WebzMetadata.FileSpecific fileSpecific, InputStream content) {
		this.fileSpecific = fileSpecific;
		this.content = content;
	}

}
