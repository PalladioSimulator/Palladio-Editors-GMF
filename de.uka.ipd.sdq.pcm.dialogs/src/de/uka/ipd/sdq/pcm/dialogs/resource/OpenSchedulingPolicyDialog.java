package de.uka.ipd.sdq.pcm.dialogs.resource;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;


public class OpenSchedulingPolicyDialog extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
	
		ProcessingResourceSpecification specification = (ProcessingResourceSpecification) ((View)((IGraphicalEditPart) getHost()).getParent().getModel()).getElement();
		ResourceSet set = (specification.getResourceContainer_ProcessingResourceSpecification()).eResource().getResourceSet();  
		EObject policy = null;
		ArrayList<Object> filterList = new ArrayList<Object>(); // positive filter
		// Set types to show and their super types
		filterList.add(SchedulingPolicy.class);
		filterList.add(ResourceRepository.class);
		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		// set EReference that should be set (in this case: SchedulingPolicy)
		additionalReferences.add(ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_SchedulingPolicy());
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				set);
		dialog.setProvidedService(SchedulingPolicy.class);
		dialog.open();
		
		if (dialog.getResult() == null) {
			return null;
		}

		if (!(dialog.getResult() instanceof SchedulingPolicy)){
			return null;
		}
		policy = dialog.getResult();
		
		ICommand icmd = new SetValueCommand(
				new SetRequest(
						specification, 
						ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_SchedulingPolicy(),
						policy));
		return new ICommandProxy(icmd);
	}

}
