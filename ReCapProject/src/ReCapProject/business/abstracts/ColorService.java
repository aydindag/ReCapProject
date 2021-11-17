package ReCapProject.business.abstracts;

import java.util.List;

import ReCapProject.core.utilities.result.DataResult;
import ReCapProject.core.utilities.result.Result;
import ReCapProject.entities.concretes.Color;


public interface ColorService {
	DataResult<List<Color>> getAll();
	Result add(Color color);
	Result remove(int colorId);
	Result update(Color Color);
	Color getById(int id);
}
