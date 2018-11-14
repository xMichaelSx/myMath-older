package myMath;

import java.util.Comparator;
import de.erichseifert.gral.plots.colors.Grayscale;
public class Monom_Comperator implements Comparator<Monom> {
	
	@Override
	public int compare(Monom ot1, Monom ot2) {
		if (ot1.get_power()>ot2.get_power())
			return 1;
		if (ot1.get_power()<ot2.get_power())
			return -1;
		if (ot1.get_coefficient()>ot2.get_coefficient())
			return 1;
		if (ot1.get_coefficient()<ot2.get_coefficient())
			return -1;
		return 0;
	}

}