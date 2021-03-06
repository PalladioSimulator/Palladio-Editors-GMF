/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.custom.edit.parts;

import java.io.NotSerializableException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser;

import de.uka.ipd.sdq.pcm.gmf.repository.custom.Activator;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * The custom variable characterisation EditPart.
 */
public class CustomVariableCharacterisationEditPart extends VariableCharacterisationEditPart {

    protected static final StoExSerialiser STOEX_SERIALISER = StoExSerialiser.createInstance();
    
    /**
     * The constructor.
     * 
     * @param view
     *            a View
     */
    public CustomVariableCharacterisationEditPart(View view) {
        super(view);
    }

    @Override
    protected String getLabelText() {
        String text = null;
        VariableCharacterisation vc = (VariableCharacterisation) this.resolveSemanticElement();
        if (vc != null && vc.getSpecification_VariableCharacterisation() != null) {
            text = vc.getType().getLiteral() + " = ";
            Expression expression = vc.getSpecification_VariableCharacterisation().getExpression();
            if (expression != null) {
                try {
                    text += STOEX_SERIALISER.serialise(expression);
                } catch (NotSerializableException e) {
                    Activator.getDefault().getLog().error("Could not serialise expression.", e);
                    text = null;
                }
            }
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(figure);
        }
        return text;
    }

    @Override
    protected void addSemanticListeners() {
        VariableCharacterisation characterisation = (VariableCharacterisation) resolveSemanticElement();
        addListenerFilter("SemanticModel", this, characterisation.getSpecification_VariableCharacterisation());
        addListenerFilter("SemanticModel2", this, characterisation);
    }

    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel");
        removeListenerFilter("SemanticModel2");
    }

    @Override
    protected void handleNotificationEvent(Notification event) {
        Object feature = event.getFeature();
        if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
            Integer c = (Integer) event.getNewValue();
            setFontColor(DiagramColorRegistry.getInstance().getColor(c));
        } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
            refreshUnderline();
        } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
            refreshStrikeThrough();
        } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
            refreshFont();
        } else {
            refreshLabel();
        }
        super.handleNotificationEvent(event);
    }
}
