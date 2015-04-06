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
import java.io.OutputStream;
import java.util.Collection;

/** TODO !!! describe !!! **/
public interface WebzFile {

	/** TODO !!! describe !!! **/
	public String getPathname();

	/** TODO !!! describe !!! **/
	public boolean isPathnameInvalid();

	/** TODO !!! describe !!! **/
	public boolean isHidden() throws WebzPathnameException;

	/** TODO !!! describe !!! **/
	public WebzFile getParent() throws WebzPathnameException;

	/** TODO !!! describe !!! **/
	public WebzFile getDescendant(String relativePathname) throws WebzPathnameException;

	/** TODO !!! describe !!! **/
	public boolean belongsToSubtree(WebzFile subtree) throws WebzPathnameException;

	/** TODO !!! describe !!! **/
	public boolean belongsToSubtree(String subtreePath) throws WebzPathnameException;

	/** TODO !!! describe !!! **/
	public void inflate() throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata getMetadata() throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzReaderDownloader getFileDownloader() throws IOException, WebzException;

	/** TODO !!! describe !!! **/
	public WebzMetadata.FileSpecific copyContentToOutputStream(OutputStream out) throws IOException, WebzReadException, WebzWriteException,
			WebzException;

	/** TODO !!! describe !!! **/
	public byte[] getFileContent() throws IOException, WebzReadException, WebzWriteException, WebzException;

	/** TODO !!! describe !!! **/
	public Collection<WebzFile> listChildren(boolean includeHidden) throws IOException, WebzException;

}
