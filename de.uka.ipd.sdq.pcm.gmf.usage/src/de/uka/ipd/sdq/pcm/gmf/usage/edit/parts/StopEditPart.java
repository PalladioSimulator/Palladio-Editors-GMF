/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.StopItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class StopEditPart extends ShapeNodeEditPart {

    /**
     * @generated
     */
    public static final int VISUAL_ID = 3002;

    /**
     * @generated
     */
    protected IFigure contentPane;

    /**
     * @generated
     */
    protected IFigure primaryShape;

    /**
     * @generated
     */
    public StopEditPart(View view) {
        super(view);
    }

    /**
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new StopItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * @generated
     */
    protected LayoutEditPolicy createLayoutEditPolicy() {
        LayoutEditPolicy lep = new LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
     * @generated
     */
    protected IFigure createNodeShape() {
        StopFigure figure = new StopFigure();
        return primaryShape = figure;
    }

    /**
     * @generated
     */
    public StopFigure getPrimaryShape() {
        return (StopFigure) primaryShape;
    }

    /**
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(30, 30);
        return result;
    }

    /**
     * @generated
     */
    public EditPolicy getPrimaryDragEditPolicy() {
        EditPolicy result = super.getPrimaryDragEditPolicy();
        if (result instanceof ResizableEditPolicy) {
            ResizableEditPolicy ep = (ResizableEditPolicy) result;
            ep.setResizeDirections(PositionConstants.NONE);
        }
        return result;
    }

    /**
     * @generated
     */
    protected NodeFigure createNodeFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSource() {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnSourceAndTarget(
            IGraphicalEditPart targetEditPart) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (targetEditPart instanceof StartEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof EntryLevelSystemCallEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof LoopEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof BranchEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof DelayEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForTarget(
            IElementType relationshipType) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Start_3001);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Stop_3002);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Loop_3005);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Branch_3008);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Delay_3017);
        }
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMARelTypesOnTarget() {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        return types;
    }

    /**
     * @generated
     */
    public List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */getMATypesForSource(
            IElementType relationshipType) {
        List/* <org.eclipse.gmf.runtime.emf.type.core.IElementType> */types = new ArrayList/*
                                                                                            * <org.
                                                                                            * eclipse
                                                                                            * .gmf.
                                                                                            * runtime
                                                                                            * .
                                                                                            * emf.type
                                                                                            * .core.
                                                                                            * IElementType
                                                                                            * >
                                                                                            */();
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Start_3001);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Stop_3002);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Loop_3005);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Branch_3008);
        }
        if (relationshipType == PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002) {
            types.add(PalladioComponentModelElementTypes.Delay_3017);
        }
        return types;
    }

    /**
     * @generated
     */
    public class StopFigure extends Ellipse {

        /**
         * @generated
         */
        public StopFigure() {
            this.setLayoutManager(new StackLayout());
            this.setLineWidth(1);
            this.setPreferredSize(new Dimension(getMapMode().DPtoLP(30), getMapMode().DPtoLP(30)));
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

            this.setBorder(new MarginBorder(getMapMode().DPtoLP(3), getMapMode().DPtoLP(3), getMapMode().DPtoLP(3),
                    getMapMode().DPtoLP(3)));
            createContents();
        }

        /**
         * @generated
         */
        private void createContents() {

            Ellipse innerCircle0 = new Ellipse();
            innerCircle0.setLineWidth(1);
            innerCircle0.setBackgroundColor(ColorConstants.black);

            this.add(innerCircle0);

        }

        /**
         * @generated
         */
        private boolean myUseLocalCoordinates = false;

        /**
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

    }

}
