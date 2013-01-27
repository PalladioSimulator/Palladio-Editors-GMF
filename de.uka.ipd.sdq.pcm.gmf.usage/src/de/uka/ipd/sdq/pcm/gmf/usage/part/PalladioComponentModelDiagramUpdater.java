/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallParameterUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenario2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioUsageScenarioCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

    /**
     * @generated
     */
    public static List getSemanticChildren(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case LoopEditPart.VISUAL_ID:
            return getLoop_3005SemanticChildren(view);
        case BranchTransitionEditPart.VISUAL_ID:
            return getBranchTransition_3009SemanticChildren(view);
        case UsageScenarioUsageScenarioCompartmentEditPart.VISUAL_ID:
            return getUsageScenarioUsageScenarioCompartment_7012SemanticChildren(view);
        case ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart.VISUAL_ID:
            return getScenarioBehaviourScenarioBehaviourStepsCompartment_7013SemanticChildren(view);
        case EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID:
            return getEntryLevelSystemCallSystemCallVariableUsageCompartment_7002SemanticChildren(view);
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
            return getVariableUsageVariableCharacterisation_7011SemanticChildren(view);
        case ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart.VISUAL_ID:
            return getScenarioBehaviourScenarioBehaviourStepsCompartment_7005SemanticChildren(view);
        case BranchUsageBranchTransitionsCompartmentEditPart.VISUAL_ID:
            return getBranchUsageBranchTransitionsCompartment_7009SemanticChildren(view);
        case ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart.VISUAL_ID:
            return getScenarioBehaviourScenarioBehaviourStepsCompartment_7008SemanticChildren(view);
        case UsageScenarioEditPart.VISUAL_ID:
            return getUsageModel_1000SemanticChildren(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getLoop_3005SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        Loop modelElement = (Loop) view.getElement();
        List result = new LinkedList();
        {
            ScenarioBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ScenarioBehaviour2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getBranchTransition_3009SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        BranchTransition modelElement = (BranchTransition) view.getElement();
        List result = new LinkedList();
        {
            ScenarioBehaviour childElement = modelElement.getBranchedBehaviour_BranchTransition();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ScenarioBehaviour3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getUsageScenarioUsageScenarioCompartment_7012SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        UsageScenario modelElement = (UsageScenario) containerView.getElement();
        List result = new LinkedList();
        {
            ScenarioBehaviour childElement = modelElement.getScenarioBehaviour_UsageScenario();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ScenarioBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        {
            Workload childElement = modelElement.getWorkload_UsageScenario();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ClosedWorkloadEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
            if (visualID == OpenWorkloadEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviourScenarioBehaviourStepsCompartment_7013SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ScenarioBehaviour modelElement = (ScenarioBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getActions_ScenarioBehaviour().iterator(); it.hasNext();) {
            AbstractUserAction childElement = (AbstractUserAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EntryLevelSystemCallEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == DelayEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getEntryLevelSystemCallSystemCallVariableUsageCompartment_7002SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        EntryLevelSystemCall modelElement = (EntryLevelSystemCall) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInputParameterUsages_EntryLevelSystemCall().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsageEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getVariableUsageVariableCharacterisation_7011SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisationEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviourScenarioBehaviourStepsCompartment_7005SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ScenarioBehaviour modelElement = (ScenarioBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getActions_ScenarioBehaviour().iterator(); it.hasNext();) {
            AbstractUserAction childElement = (AbstractUserAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EntryLevelSystemCallEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == DelayEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getBranchUsageBranchTransitionsCompartment_7009SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        Branch modelElement = (Branch) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getBranchTransitions_Branch().iterator(); it.hasNext();) {
            BranchTransition childElement = (BranchTransition) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == BranchTransitionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviourScenarioBehaviourStepsCompartment_7008SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ScenarioBehaviour modelElement = (ScenarioBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getActions_ScenarioBehaviour().iterator(); it.hasNext();) {
            AbstractUserAction childElement = (AbstractUserAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EntryLevelSystemCallEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == DelayEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getUsageModel_1000SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        UsageModel modelElement = (UsageModel) view.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getUsageScenario_UsageModel().iterator(); it.hasNext();) {
            UsageScenario childElement = (UsageScenario) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == UsageScenario2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List getContainedLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case UsageScenarioEditPart.VISUAL_ID:
            return getUsageModel_1000ContainedLinks(view);
        case UsageScenario2EditPart.VISUAL_ID:
            return getUsageScenario_2004ContainedLinks(view);
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return getScenarioBehaviour_3014ContainedLinks(view);
        case StartEditPart.VISUAL_ID:
            return getStart_3001ContainedLinks(view);
        case StopEditPart.VISUAL_ID:
            return getStop_3002ContainedLinks(view);
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return getEntryLevelSystemCall_3003ContainedLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3012ContainedLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3013ContainedLinks(view);
        case LoopEditPart.VISUAL_ID:
            return getLoop_3005ContainedLinks(view);
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return getScenarioBehaviour_3007ContainedLinks(view);
        case BranchEditPart.VISUAL_ID:
            return getBranch_3008ContainedLinks(view);
        case BranchTransitionEditPart.VISUAL_ID:
            return getBranchTransition_3009ContainedLinks(view);
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return getScenarioBehaviour_3010ContainedLinks(view);
        case DelayEditPart.VISUAL_ID:
            return getDelay_3017ContainedLinks(view);
        case ClosedWorkloadEditPart.VISUAL_ID:
            return getClosedWorkload_3015ContainedLinks(view);
        case OpenWorkloadEditPart.VISUAL_ID:
            return getOpenWorkload_3016ContainedLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getIncomingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case UsageScenario2EditPart.VISUAL_ID:
            return getUsageScenario_2004IncomingLinks(view);
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return getScenarioBehaviour_3014IncomingLinks(view);
        case StartEditPart.VISUAL_ID:
            return getStart_3001IncomingLinks(view);
        case StopEditPart.VISUAL_ID:
            return getStop_3002IncomingLinks(view);
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return getEntryLevelSystemCall_3003IncomingLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3012IncomingLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3013IncomingLinks(view);
        case LoopEditPart.VISUAL_ID:
            return getLoop_3005IncomingLinks(view);
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return getScenarioBehaviour_3007IncomingLinks(view);
        case BranchEditPart.VISUAL_ID:
            return getBranch_3008IncomingLinks(view);
        case BranchTransitionEditPart.VISUAL_ID:
            return getBranchTransition_3009IncomingLinks(view);
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return getScenarioBehaviour_3010IncomingLinks(view);
        case DelayEditPart.VISUAL_ID:
            return getDelay_3017IncomingLinks(view);
        case ClosedWorkloadEditPart.VISUAL_ID:
            return getClosedWorkload_3015IncomingLinks(view);
        case OpenWorkloadEditPart.VISUAL_ID:
            return getOpenWorkload_3016IncomingLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getOutgoingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case UsageScenario2EditPart.VISUAL_ID:
            return getUsageScenario_2004OutgoingLinks(view);
        case ScenarioBehaviourEditPart.VISUAL_ID:
            return getScenarioBehaviour_3014OutgoingLinks(view);
        case StartEditPart.VISUAL_ID:
            return getStart_3001OutgoingLinks(view);
        case StopEditPart.VISUAL_ID:
            return getStop_3002OutgoingLinks(view);
        case EntryLevelSystemCallEditPart.VISUAL_ID:
            return getEntryLevelSystemCall_3003OutgoingLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3012OutgoingLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3013OutgoingLinks(view);
        case LoopEditPart.VISUAL_ID:
            return getLoop_3005OutgoingLinks(view);
        case ScenarioBehaviour2EditPart.VISUAL_ID:
            return getScenarioBehaviour_3007OutgoingLinks(view);
        case BranchEditPart.VISUAL_ID:
            return getBranch_3008OutgoingLinks(view);
        case BranchTransitionEditPart.VISUAL_ID:
            return getBranchTransition_3009OutgoingLinks(view);
        case ScenarioBehaviour3EditPart.VISUAL_ID:
            return getScenarioBehaviour_3010OutgoingLinks(view);
        case DelayEditPart.VISUAL_ID:
            return getDelay_3017OutgoingLinks(view);
        case ClosedWorkloadEditPart.VISUAL_ID:
            return getClosedWorkload_3015OutgoingLinks(view);
        case OpenWorkloadEditPart.VISUAL_ID:
            return getOpenWorkload_3016OutgoingLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getUsageModel_1000ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getUsageScenario_2004ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3014ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getStart_3001ContainedLinks(View view) {
        Start modelElement = (Start) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getStop_3002ContainedLinks(View view) {
        Stop modelElement = (Stop) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getEntryLevelSystemCall_3003ContainedLinks(View view) {
        EntryLevelSystemCall modelElement = (EntryLevelSystemCall) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getVariableUsage_3012ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getVariableCharacterisation_3013ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getLoop_3005ContainedLinks(View view) {
        Loop modelElement = (Loop) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3007ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getBranch_3008ContainedLinks(View view) {
        Branch modelElement = (Branch) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getBranchTransition_3009ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3010ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getDelay_3017ContainedLinks(View view) {
        Delay modelElement = (Delay) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getClosedWorkload_3015ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getOpenWorkload_3016ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getUsageScenario_2004IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3014IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getStart_3001IncomingLinks(View view) {
        Start modelElement = (Start) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getStop_3002IncomingLinks(View view) {
        Stop modelElement = (Stop) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getEntryLevelSystemCall_3003IncomingLinks(View view) {
        EntryLevelSystemCall modelElement = (EntryLevelSystemCall) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getVariableUsage_3012IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getVariableCharacterisation_3013IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getLoop_3005IncomingLinks(View view) {
        Loop modelElement = (Loop) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3007IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getBranch_3008IncomingLinks(View view) {
        Branch modelElement = (Branch) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getBranchTransition_3009IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3010IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getDelay_3017IncomingLinks(View view) {
        Delay modelElement = (Delay) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List getClosedWorkload_3015IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getOpenWorkload_3016IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getUsageScenario_2004OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3014OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getStart_3001OutgoingLinks(View view) {
        Start modelElement = (Start) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getStop_3002OutgoingLinks(View view) {
        Stop modelElement = (Stop) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getEntryLevelSystemCall_3003OutgoingLinks(View view) {
        EntryLevelSystemCall modelElement = (EntryLevelSystemCall) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getVariableUsage_3012OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getVariableCharacterisation_3013OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getLoop_3005OutgoingLinks(View view) {
        Loop modelElement = (Loop) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3007OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getBranch_3008OutgoingLinks(View view) {
        Branch modelElement = (Branch) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getBranchTransition_3009OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getScenarioBehaviour_3010OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getDelay_3017OutgoingLinks(View view) {
        Delay modelElement = (Delay) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List getClosedWorkload_3015OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public static List getOpenWorkload_3016OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    private static Collection getIncomingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(
            AbstractUserAction target, Map crossReferences) {
        Collection result = new LinkedList();
        Collection settings = (Collection) crossReferences.get(target);
        for (Iterator it = settings.iterator(); it.hasNext();) {
            EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
            if (setting.getEStructuralFeature() == UsagemodelPackage.eINSTANCE.getAbstractUserAction_Successor()) {
                result.add(new PalladioComponentModelLinkDescriptor(setting.getEObject(), target,
                        PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002,
                        AbstractUserActionSuccessorEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection getOutgoingFeatureModelFacetLinks_AbstractUserAction_Successor_4002(
            AbstractUserAction source) {
        Collection result = new LinkedList();
        AbstractUserAction destination = source.getSuccessor();
        if (destination == null) {
            return result;
        }
        result.add(new PalladioComponentModelLinkDescriptor(source, destination,
                PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002,
                AbstractUserActionSuccessorEditPart.VISUAL_ID));
        return result;
    }

}
