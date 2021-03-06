/*
 *  Copyright 2015 LG CNS.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 *
 */
package scouter.client.actions;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;

import scouter.client.util.ImageUtil;
import scouter.client.views.ObjectActiveServiceListView;


public class OpenActiveServiceListAction extends Action {
	public final static String ID = OpenActiveServiceListAction.class.getName();

	private final IWorkbenchWindow window;
	private String objType;
	private int serverId;

	public OpenActiveServiceListAction(IWorkbenchWindow window, String label, String objType, Image image, int serverId) {
		this.window = window;
		this.serverId = serverId;
		setText(label);
		setId(ID);
		setImageDescriptor(ImageUtil.getImageDescriptor(image));
		this.objType = objType;
	}

	public void run() {
		if (window != null) {
			try {
				window.getActivePage().showView(ObjectActiveServiceListView.ID, serverId + "&" + objType, IWorkbenchPage.VIEW_ACTIVATE);
			} catch (PartInitException e) {
				MessageDialog.openError(window.getShell(), "Error", "Error opening view:" + e.getMessage());
			}
		}
	}
}
