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
import java.io.OutputStream;
import java.util.Collection;

import org.terems.webz.WebzException;
import org.terems.webz.WebzFile;
import org.terems.webz.WebzFileDownloader;
import org.terems.webz.WebzMetadata;
import org.terems.webz.WebzMetadata.FileSpecific;
import org.terems.webz.WebzPathnameException;
import org.terems.webz.WebzReadException;
import org.terems.webz.WebzWriteException;

/** TODO !!! describe !!! **/
public abstract class WebzFileProxy implements WebzFile {

	/** TODO !!! describe !!! **/
	protected abstract WebzFile getInternalFile();

	@Override
	public String getPathname() {
		return getInternalFile().getPathname();
	}

	@Override
	public boolean isPathnameInvalid() {
		return getInternalFile().isPathnameInvalid();
	}

	@Override
	public boolean isHidden() throws WebzPathnameException {
		return getInternalFile().isHidden();
	}

	@Override
	public WebzFile getParent() throws WebzPathnameException {
		return getInternalFile().getParent();
	}

	@Override
	public WebzFile getDescendant(String relativePathname) throws WebzPathnameException {
		return getInternalFile().getDescendant(relativePathname);
	}

	@Override
	public boolean belongsToSubtree(WebzFile subtree) throws WebzPathnameException {
		return getInternalFile().belongsToSubtree(subtree);
	}

	@Override
	public boolean belongsToSubtree(String subtreePath) throws WebzPathnameException {
		return getInternalFile().belongsToSubtree(subtreePath);
	}

	@Override
	public void inflate() throws IOException, WebzException {
		getInternalFile().inflate();
	}

	@Override
	public WebzMetadata getMetadata() throws IOException, WebzException {
		return getInternalFile().getMetadata();
	}

	@Override
	public WebzFileDownloader getFileDownloader() throws IOException, WebzException {
		return getInternalFile().getFileDownloader();
	}

	@Override
	public FileSpecific copyContentToOutputStream(OutputStream out) throws IOException, WebzReadException, WebzWriteException,
			WebzException {
		return getInternalFile().copyContentToOutputStream(out);
	}

	@Override
	public byte[] getFileContent() throws IOException, WebzReadException, WebzWriteException, WebzException {
		return getInternalFile().getFileContent();
	}

	@Override
	public Collection<WebzFile> listChildren(boolean includeHidden) throws IOException, WebzException {
		return getInternalFile().listChildren(includeHidden);
	}

}
