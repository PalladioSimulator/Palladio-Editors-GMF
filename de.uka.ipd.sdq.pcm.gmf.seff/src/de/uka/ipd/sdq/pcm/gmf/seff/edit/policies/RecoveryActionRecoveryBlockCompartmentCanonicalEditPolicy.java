/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class RecoveryActionRecoveryBlockCompartmentCanonicalEditPolicy.
 *
 * @generated
 */
public class RecoveryActionRecoveryBlockCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

    /** The my features to synchronize. @generated */
    Set myFeaturesToSynchronize;

    /**
     * Gets the semantic children list.
     *
     * @return the semantic children list
     * @generated
     */
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        List result = new LinkedList();
        for (Iterator it = PalladioComponentModelDiagramUpdater
                .getRecoveryActionRecoveryBlockCompartment_7054SemanticChildren(viewObject).iterator(); it.hasNext();) {
            result.add(((PalladioComponentModelNodeDescriptor) it.next()).getModelElement());
        }
        return result;
    }

    /**
     * Checks if is orphaned.
     *
     * @param semanticChildren the semantic children
     * @param view the view
     * @return true, if is orphaned
     * @generated
     */
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            if (!semanticChildren.contains(view.getElement())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the default factory hint.
     *
     * @return the default factory hint
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

    /**
     * Gets the features to synchronize.
     *
     * @return the features to synchronize
     * @generated
     */
    protected Set getFeaturesToSynchronize() {
        if (myFeaturesToSynchronize == null) {
            myFeaturesToSynchronize = new HashSet();
            myFeaturesToSynchronize.add(de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                    .getRecoveryAction_RecoveryActionBehaviours__RecoveryAction());
        }
        return myFeaturesToSynchronize;
    }

}
