/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy.
 *
 * @generated
 */
public class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy
		extends CanonicalEditPolicy {

	/** The my features to synchronize. @generated */
	Set myFeaturesToSynchronize;

	/**
	 * Gets the semantic children list.
	 *
	 * @return the semantic children list
	 * @generated not
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		EObject modelObject = viewObject.getElement();
		List result = new LinkedList();

		if (modelObject != null && modelObject instanceof ComposedStructure) {
			for (AssemblyContext assemblyContext : ((ComposedStructure) modelObject)
					.getAssemblyContexts__ComposedStructure()) {

				int assemblyNodeVID = PalladioComponentModelVisualIDRegistry
						.getNodeVisualID(viewObject, assemblyContext);
				if (AssemblyContextEditPart.VISUAL_ID == assemblyNodeVID) {
					result.add(assemblyContext);
				}
			}
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
		case AssemblyContextEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize
					.add(EntityPackage.eINSTANCE
							.getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity());
		}
		return myFeaturesToSynchronize;
	}

}
