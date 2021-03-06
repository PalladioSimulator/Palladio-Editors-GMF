/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import java.io.NotSerializableException;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser;

import de.uka.ipd.sdq.pcm.gmf.repository.custom.Activator;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;

/**
 * A custom variable usage EditPart.
 */
public class CustomVariableUsageEditPart extends VariableUsageEditPart {

    protected static final StoExSerialiser STOEX_SERIALISER = StoExSerialiser.createInstance();
    
    /**
     * The constructor.
     *
     * @param view
     *            a View
     */
    public CustomVariableUsageEditPart(final View view) {
        super(view);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected IFigure createNodeShape() {
        final ParametricParameterUsageFigure2 figure = new ParametricParameterUsageFigure2();
        primaryShape = figure;
        return primaryShape;
    }

    // I left the @generated tags in, so it is clear what part(s) of the class has been modified.
    // Somewhat dirty but the lesser evil imho.

    /**
     * A parametric parameter usage figure.
     */
    public class ParametricParameterUsageFigure2 extends ParametricParameterUsageFigure {

        /**
         * @generated
         */
        private WrappingLabel fFigureVariableUsageReferenceLabelFigure;

        /**
         * @generated not
         */
        public ParametricParameterUsageFigure2() {
            super();

            createContents();
        }

        /**
         * @generated not
         */
        private void createContents() {

            fFigureVariableUsageReferenceLabelFigure = this.getFigureVariableUsageReferenceLabelFigure();
            AbstractNamedReference reference = ((VariableUsage) resolveSemanticElement()).getNamedReference__VariableUsage();
            String referenceText = null;
            try {
                referenceText = STOEX_SERIALISER.serialise(reference);
            } catch (NotSerializableException e) {
                Activator.getDefault().getLog().error("Could not serialise reference.", e);
            }
            
            if (referenceText != null) {
                fFigureVariableUsageReferenceLabelFigure.setText(referenceText);
            } else {
                fFigureVariableUsageReferenceLabelFigure.setText("<null>");
            }

        }

    }

}
