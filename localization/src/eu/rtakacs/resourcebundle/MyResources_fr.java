package eu.rtakacs.resourcebundle;

import java.util.ListResourceBundle;

public class MyResources_fr extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				// LOCALIZE THIS
				{ "s1", "Le disque \"{1}\" {0}." }, // MessageFormat pattern
				{ "s2", "1" }, // location of {0} in pattern
				{ "s3", "Mon disque" }, // sample disk name
				{ "s4", "ne contient pas de fichiers" }, // first ChoiceFormat choice
				{ "s5", "contient un fichier" }, // second ChoiceFormat choice
				{ "s6", "contient {0,number} fichiers" }, // third ChoiceFormat choice
				{ "s7", "3 mars 1996" }, // sample date
				{ "s8", new Dimension(1, 3) } // real object, not just string
				// END OF MATERIAL TO LOCALIZE
		};
	}

}
