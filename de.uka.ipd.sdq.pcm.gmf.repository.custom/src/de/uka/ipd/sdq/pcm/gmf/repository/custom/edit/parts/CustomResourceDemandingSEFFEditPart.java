/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.policies.CustomOpenSeffDiagramEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.PalladioComponentModelTextNonResizableEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.ResourceDemandingSEFFItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

public class CustomResourceDemandingSEFFEditPart extends ResourceDemandingSEFFEditPart {

    public CustomResourceDemandingSEFFEditPart(View view) {
        super(view);
    }

    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ResourceDemandingSEFFItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PalladioComponentModelTextNonResizableEditPolicy());
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new CustomOpenSeffDiagramEditPolicy());
    }

    @Override
    protected String getLabelText() {
        String text = "SEFF <";
        Signature describedService = ((ResourceDemandingSEFF) ((View) this.getModel()).getElement())
                .getDescribedService__SEFF();
        if (describedService != null)
            text += describedService.getEntityName();
        return text + ">";
    }

}
