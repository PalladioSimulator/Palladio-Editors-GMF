/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InternalActionInfrastructureCallsCompartment2CanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.Messages;

/**
 * The Class InternalActionInfrastructureCallsCompartment2EditPart.
 *
 * @generated
 */
public class InternalActionInfrastructureCallsCompartment2EditPart extends ListCompartmentEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 7051;

    /**
     * Instantiates a new internal action infrastructure calls compartment2 edit part.
     *
     * @param view the view
     * @generated
     */
    public InternalActionInfrastructureCallsCompartment2EditPart(View view) {
        super(view);
    }

    /**
     * Checks for model children changed.
     *
     * @param evt the evt
     * @return true, if successful
     * @generated
     */
    protected boolean hasModelChildrenChanged(Notification evt) {
        return false;
    }

    /**
     * Gets the compartment name.
     *
     * @return the compartment name
     * @generated
     */
    public String getCompartmentName() {
        return Messages.InternalActionInfrastructureCallsCompartment2EditPart_title;
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableCompartmentEditPolicy());
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
                new InternalActionInfrastructureCallsCompartment2ItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
                new InternalActionInfrastructureCallsCompartment2CanonicalEditPolicy());
    }

    /**
     * Sets the ratio.
     *
     * @param ratio the new ratio
     * @generated
     */
    protected void setRatio(Double ratio) {
        if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
            super.setRatio(ratio);
        }
    }

}
