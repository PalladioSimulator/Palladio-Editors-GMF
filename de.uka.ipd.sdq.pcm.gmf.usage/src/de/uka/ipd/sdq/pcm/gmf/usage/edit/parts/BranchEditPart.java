/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.BranchItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * The Class BranchEditPart.
 *
 * @generated
 */
public class BranchEditPart extends ShapeNodeEditPart {

    /** The Constant VISUAL_ID. @generated */
    public static final int VISUAL_ID = 3008;

    /** The content pane. @generated */
    protected IFigure contentPane;

    /** The primary shape. @generated */
    protected IFigure primaryShape;

    /**
     * Instantiates a new branch edit part.
     *
     * @param view the view
     * @generated
     */
    public BranchEditPart(View view) {
        super(view);
    }

    /**
     * Creates the default edit policies.
     *
     * @generated
     */
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BranchItemSemanticEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children
        // add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
     * Creates the layout edit policy.
     *
     * @return the layout edit policy
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
     * Creates the node shape.
     *
     * @return the i figure
     * @generated
     */
    protected IFigure createNodeShape() {
        UsageBranchFigure figure = new UsageBranchFigure();
        return primaryShape = figure;
    }

    /**
     * Gets the primary shape.
     *
     * @return the primary shape
     * @generated
     */
    public UsageBranchFigure getPrimaryShape() {
        return (UsageBranchFigure) primaryShape;
    }

    /**
     * Adds the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof BranchUsageBranchTransitionsCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureBranchCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.add(((BranchUsageBranchTransitionsCompartmentEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * Removes the fixed child.
     *
     * @param childEditPart the child edit part
     * @return true, if successful
     * @generated
     */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof BranchUsageBranchTransitionsCompartmentEditPart) {
            IFigure pane = getPrimaryShape().getFigureBranchCompartment();
            setupContentPane(pane); // FIXME each comparment should handle his content pane in his
                                    // own way
            pane.remove(((BranchUsageBranchTransitionsCompartmentEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
     * Adds the child visual.
     *
     * @param childEditPart the child edit part
     * @param index the index
     * @generated
     */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
     * Removes the child visual.
     *
     * @param childEditPart the child edit part
     * @generated
     */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
     * Gets the content pane for.
     *
     * @param editPart the edit part
     * @return the content pane for
     * @generated
     */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof BranchUsageBranchTransitionsCompartmentEditPart) {
            return getPrimaryShape().getFigureBranchCompartment();
        }
        return getContentPane();
    }

    /**
     * Creates the node plate.
     *
     * @return the node figure
     * @generated
     */
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
     * Creates figure for this edit part.
     * 
     * Body of this method does not depend on settings in generation model so you may safely remove
     * <i>generated</i> tag and modify it.
     *
     * @return the node figure
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
     * Default implementation treats passed figure as content pane. Respects layout one may have set
     * for generated figure.
     *
     * @param nodeShape instance of generated figure class
     * @return the i figure
     * @generated
     */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
     * Gets the content pane.
     *
     * @return the content pane
     * @generated
     */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
     * Sets the foreground color.
     *
     * @param color the new foreground color
     * @generated
     */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
     * Sets the background color.
     *
     * @param color the new background color
     * @generated
     */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
     * Sets the line width.
     *
     * @param width the new line width
     * @generated
     */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
     * Sets the line type.
     *
     * @param style the new line type
     * @generated
     */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
     * Gets the mA rel types on source.
     *
     * @return the mA rel types on source
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
     * Gets the mA rel types on source and target.
     *
     * @param targetEditPart the target edit part
     * @return the mA rel types on source and target
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
        if (targetEditPart instanceof StopEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof EntryLevelSystemCallEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof LoopEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        if (targetEditPart instanceof DelayEditPart) {
            types.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
        }
        return types;
    }

    /**
     * Gets the mA types for target.
     *
     * @param relationshipType the relationship type
     * @return the mA types for target
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
     * Gets the mA rel types on target.
     *
     * @return the mA rel types on target
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
     * Gets the mA types for source.
     *
     * @param relationshipType the relationship type
     * @return the mA types for source
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
     * The Class UsageBranchFigure.
     *
     * @generated
     */
    public class UsageBranchFigure extends RoundedRectangle {
        
        /** The figure usage branch stereotype label figure. @generated */
        private WrappingLabel fFigureUsageBranchStereotypeLabelFigure;

        /** The figure branch compartment. @generated */
        private RectangleFigure fFigureBranchCompartment;

        /**
         * Instantiates a new usage branch figure.
         *
         * @generated
         */
        public UsageBranchFigure() {

            GridLayout layoutThis = new GridLayout();
            layoutThis.numColumns = 1;
            layoutThis.makeColumnsEqualWidth = true;
            layoutThis.horizontalSpacing = 0;
            layoutThis.verticalSpacing = 0;
            layoutThis.marginWidth = 0;
            layoutThis.marginHeight = 0;
            this.setLayoutManager(layoutThis);

            this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
            this.setLineWidth(1);
            this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
            createContents();
        }

        /**
         * Creates the contents.
         *
         * @generated
         */
        private void createContents() {

            fFigureUsageBranchStereotypeLabelFigure = new WrappingLabel();
            fFigureUsageBranchStereotypeLabelFigure.setText("<<Branch>>");
            fFigureUsageBranchStereotypeLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode()
                    .DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

            GridData constraintFFigureUsageBranchStereotypeLabelFigure = new GridData();
            constraintFFigureUsageBranchStereotypeLabelFigure.verticalAlignment = GridData.BEGINNING;
            constraintFFigureUsageBranchStereotypeLabelFigure.horizontalAlignment = GridData.CENTER;
            constraintFFigureUsageBranchStereotypeLabelFigure.horizontalIndent = 0;
            constraintFFigureUsageBranchStereotypeLabelFigure.horizontalSpan = 1;
            constraintFFigureUsageBranchStereotypeLabelFigure.verticalSpan = 1;
            constraintFFigureUsageBranchStereotypeLabelFigure.grabExcessHorizontalSpace = true;
            constraintFFigureUsageBranchStereotypeLabelFigure.grabExcessVerticalSpace = false;
            this.add(fFigureUsageBranchStereotypeLabelFigure, constraintFFigureUsageBranchStereotypeLabelFigure);

            fFigureBranchCompartment = new RectangleFigure();
            fFigureBranchCompartment.setFill(false);
            fFigureBranchCompartment.setOutline(false);
            fFigureBranchCompartment.setLineWidth(1);
            fFigureBranchCompartment.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));

            GridData constraintFFigureBranchCompartment = new GridData();
            constraintFFigureBranchCompartment.verticalAlignment = GridData.FILL;
            constraintFFigureBranchCompartment.horizontalAlignment = GridData.FILL;
            constraintFFigureBranchCompartment.horizontalIndent = 0;
            constraintFFigureBranchCompartment.horizontalSpan = 1;
            constraintFFigureBranchCompartment.verticalSpan = 1;
            constraintFFigureBranchCompartment.grabExcessHorizontalSpace = true;
            constraintFFigureBranchCompartment.grabExcessVerticalSpace = true;
            this.add(fFigureBranchCompartment, constraintFFigureBranchCompartment);

        }

        /**
         * Gets the figure usage branch stereotype label figure.
         *
         * @return the figure usage branch stereotype label figure
         * @generated
         */
        public WrappingLabel getFigureUsageBranchStereotypeLabelFigure() {
            return fFigureUsageBranchStereotypeLabelFigure;
        }

        /**
         * Gets the figure branch compartment.
         *
         * @return the figure branch compartment
         * @generated
         */
        public RectangleFigure getFigureBranchCompartment() {
            return fFigureBranchCompartment;
        }

        /** The my use local coordinates. @generated */
        private boolean myUseLocalCoordinates = false;

        /**
         * Use local coordinates.
         *
         * @return true, if successful
         * @generated
         */
        protected boolean useLocalCoordinates() {
            return myUseLocalCoordinates;
        }

        /**
         * Sets the use local coordinates.
         *
         * @param useLocalCoordinates the new use local coordinates
         * @generated
         */
        protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
            myUseLocalCoordinates = useLocalCoordinates;
        }

    }

}
