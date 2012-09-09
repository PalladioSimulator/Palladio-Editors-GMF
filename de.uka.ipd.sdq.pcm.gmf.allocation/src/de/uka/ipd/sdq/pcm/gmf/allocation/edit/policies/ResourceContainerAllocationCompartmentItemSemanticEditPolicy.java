/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands.AllocationContextCreateCommand;

import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ResourceContainerAllocationCompartmentItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated not
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.AllocationContext_3001 == req.getElementType()) {
            if (req.getContainmentFeature() == null) {
                req.setContainmentFeature(AllocationPackage.eINSTANCE.getAllocation_AllocationContexts_Allocation());
            }
            Allocation a = (Allocation) ((View) getHost().getParent().getParent().getModel()).getElement();
            return getMSLWrapper(new AllocationContextCreateCommand(req, a));
        }
        return super.getCreateCommand(req);
    }
}
