/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.helpers;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * Edit helper for operation required roles. This edit helper opens a dialog to enable the user to
 * choose the operation interface the configured role requires.
 * 
 * 
 * @generated NOT
 */
public class OperationRequiredRoleEditHelper extends PalladioComponentModelBaseEditHelper {

    @Override
    protected ICommand getConfigureCommand(ConfigureRequest request) {
        OperationInterface resource = null;

        ArrayList<Object> filterList = new ArrayList<Object>();
        filterList.add(Repository.class);
        filterList.add(OperationInterface.class);

        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, request
                .getElementToConfigure().eResource().getResourceSet());
        dialog.setProvidedService(OperationInterface.class);
        dialog.open();
        if (dialog.getResult() == null)
            return new CanceledCommand();
        if (!(dialog.getResult() instanceof OperationInterface))
            return new CanceledCommand();
        resource = (OperationInterface) dialog.getResult();

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                RepositoryPackage.eINSTANCE.getOperationRequiredRole_RequiredInterface__OperationRequiredRole(),
                resource));

        String name = "Required_" + resource.getEntityName();

        ICommand cmd2 = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                EntityPackage.eINSTANCE.getNamedElement_EntityName(), name));

        CompositeCommand cc = new CompositeCommand("Configure Required Role Context");
        cc.add(cmd);
        cc.add(cmd2);

        return cc;
    }
}
