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
public abstract class WebzMetadataProxy extends BaseWebzMetadata {

	/** TODO !!! describe !!! **/
	protected abstract WebzMetadata getInnerMetadata();

	@Override
	public String getName() throws IOException, WebzException {
		return getInnerMetadata().getName();
	}

	@Override
	public boolean isFile() throws IOException, WebzException {
		return getInnerMetadata().isFile();
	}

	@Override
	public boolean isFolder() throws IOException, WebzException {
		return getInnerMetadata().isFolder();
	}

	@Override
	public String getLinkedPathname() {
		return getInnerMetadata().getLinkedPathname();
	}

	@Override
	public String[] getOrigins() {
		return getInnerMetadata().getOrigins();
	}

	@Override
	public long getNumberOfBytes() throws IOException, WebzException {
		return getInnerMetadata().getFileSpecific().getNumberOfBytes();
	}

	@Override
	public Long getLastModified() throws IOException, WebzException {
		return getInnerMetadata().getFileSpecific().getLastModified();
	}

	@Override
	public String getRevision() throws IOException, WebzException {
		return getInnerMetadata().getFileSpecific().getRevision();
	}

}
