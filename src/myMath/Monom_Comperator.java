package myMath;

import java.util.Comparator;
<<<<<<< HEAD

=======
import de.erichseifert.gral.plots.colors.Grayscale;
>>>>>>> f3b6715887ce7de6df896240799e0710da80deb7
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