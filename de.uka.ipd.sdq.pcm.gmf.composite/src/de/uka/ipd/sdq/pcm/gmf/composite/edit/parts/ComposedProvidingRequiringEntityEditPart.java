/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityItemSemanticEditPolicy;

/**
 * Edit part for the outer edit part figure representation. The edit part containing the internal
 * elements like assembly contexts and connectors is represented by
 * 
 * @see ComposedProvidingRequiringEntity2EditPart
 * @generated
 */
public class ComposedProvidingRequiringEntityEditPart extends DiagramEditPart {

    /**
     * @generated
     */
    public final static String MODEL_ID = "CompositeModel"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static final int VISUAL_ID = 1000;

    /**
     * @generated
     */
    public ComposedProvidingRequiringEntityEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ComposedProvidingRequiringEntityItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ComposedProvidingRequiringEntityCanonicalEditPolicy());
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
    }
}
