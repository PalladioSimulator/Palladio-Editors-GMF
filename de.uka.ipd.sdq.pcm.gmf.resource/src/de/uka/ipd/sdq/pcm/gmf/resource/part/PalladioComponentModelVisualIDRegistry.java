/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationFailureProbabilityEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationLatencyLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationThroughputLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResource2EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.LinkingResourceNetworkSwitchCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationActiveResourceTypeLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationMTTFEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationMTTREditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationNumberOfReplicasEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationSchedulingPolicyEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceContainerResourceContainerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ResourceEnvironmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.WrappingLabel2EditPart;
import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.resource/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ResourceEnvironmentEditPart.MODEL_ID.equals(view.getType())) {
				return ResourceEnvironmentEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				PalladioComponentModelDiagramEditorPlugin.getInstance()
						.logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ResourceenvironmentPackage.eINSTANCE.getResourceEnvironment()
				.isSuperTypeOf(domainElement.eClass())
				&& isDiagram((ResourceEnvironment) domainElement)) {
			return ResourceEnvironmentEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry
				.getModelID(containerView);
		if (!ResourceEnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (ResourceEnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ResourceEnvironmentEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
			if (ResourceenvironmentPackage.eINSTANCE
					.getProcessingResourceSpecification().isSuperTypeOf(
							domainElement.eClass())) {
				return ProcessingResourceSpecificationEditPart.VISUAL_ID;
			}
			break;
		case LinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID:
			if (ResourceenvironmentPackage.eINSTANCE
					.getCommunicationLinkResourceSpecification().isSuperTypeOf(
							domainElement.eClass())) {
				return CommunicationLinkResourceSpecificationEditPart.VISUAL_ID;
			}
			break;
		case ResourceEnvironmentEditPart.VISUAL_ID:
			if (ResourceenvironmentPackage.eINSTANCE.getResourceContainer()
					.isSuperTypeOf(domainElement.eClass())) {
				return ResourceContainerEditPart.VISUAL_ID;
			}
			if (ResourceenvironmentPackage.eINSTANCE.getLinkingResource()
					.isSuperTypeOf(domainElement.eClass())) {
				return LinkingResource2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry
				.getModelID(containerView);
		if (!ResourceEnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (ResourceEnvironmentEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ResourceEnvironmentEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ResourceContainerEditPart.VISUAL_ID:
			if (ResourceContainerEntityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LinkingResource2EditPart.VISUAL_ID:
			if (LinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ProcessingResourceSpecificationEditPart.VISUAL_ID:
			if (ProcessingResourceSpecificationMTTFEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessingResourceSpecificationMTTREditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessingResourceSpecificationSchedulingPolicyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessingResourceSpecificationNumberOfReplicasEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessingResourceSpecificationActiveResourceTypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ProcessingResourceSpecificationProcessingResourceSpecificationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommunicationLinkResourceSpecificationEditPart.VISUAL_ID:
			if (CommunicationLinkResourceSpecificationFailureProbabilityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommunicationLinkResourceSpecificationLatencyLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (CommunicationLinkResourceSpecificationThroughputLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceContainerResourceContainerCompartmentEditPart.VISUAL_ID:
			if (ProcessingResourceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LinkingResourceNetworkSwitchCompartmentEditPart.VISUAL_ID:
			if (CommunicationLinkResourceSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceEnvironmentEditPart.VISUAL_ID:
			if (ResourceContainerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LinkingResource2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(ResourceEnvironment element) {
		return true;
	}

}
