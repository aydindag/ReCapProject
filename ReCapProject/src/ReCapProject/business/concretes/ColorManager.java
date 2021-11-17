package ReCapProject.business.concretes;

import java.util.List;

import ReCapProject.business.abstracts.ColorService;
import ReCapProject.core.utilities.result.DataResult;
import ReCapProject.core.utilities.result.ErrorResult;
import ReCapProject.core.utilities.result.Result;
import ReCapProject.core.utilities.result.SuccessDataResult;
import ReCapProject.core.utilities.result.SuccessResult;
import ReCapProject.dataAccess.abstracts.ColorRepository;
import ReCapProject.entities.concretes.Color;

public class ColorManager implements ColorService {
	
	private ColorRepository colorRepository;

	public ColorManager(ColorRepository colorRepository) {
		super();
		this.colorRepository = colorRepository;
	}

	@Override
	public DataResult<List<Color>> getAll() {
		return new SuccessDataResult<List<Color>>(this.colorRepository.getAll());
	}

	@Override
	public Result add(Color color) {
		this.colorRepository.insert(color);
		return new SuccessResult("Renk eklendi");
	}

	@Override
	public Result remove(int colorId) {
		Color color= this.colorRepository.getById(colorId);
		int index=this.colorRepository.getIndex(color);
		if(index != -1) {
			this.colorRepository.delete(colorId);
			return new SuccessResult("Renk silindi");
		}
		return new ErrorResult("Renk silme gerçekleştirilemedi");
	
	}

	@Override
	public Result update(Color color) {
		int index=this.colorRepository.getIndex(color);
		if(index != -1) {
			this.colorRepository.update(index, color);
			return new SuccessResult("Renk update edildi.");
		}
		return new ErrorResult("Renk update edilemedi.");
	}

	@Override
	public Color getById(int id) {
		return this.colorRepository.getById(id);
	}

}
