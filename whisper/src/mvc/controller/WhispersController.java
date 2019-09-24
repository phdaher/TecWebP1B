
package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.WhispersDAO;
import mvc.model.Whisper;

@Controller
public class WhispersController {
	@RequestMapping("/")
	public String execute() {
		return "whispers";
	}

	@RequestMapping("addWhisper")
	public String add(Whisper whisper) {
		WhispersDAO dao = new WhispersDAO();
		dao.addWhisper(whisper);
		dao.close();
		return "redirect";
	}
	
	@RequestMapping("updateForm")
	public String updateForm() {
		return "updateForm";
	}
	
	@RequestMapping("updateWhisper")
	public String update(Whisper whisper) {
		WhispersDAO dao = new WhispersDAO();
		dao.updateWhisper(whisper);
		dao.close();
		return "redirect";
	}
	
	@RequestMapping("deleteWhisper")
	public String delete(Integer id) {
		WhispersDAO dao = new WhispersDAO();
		dao.removeWhisper(id);
		dao.close();
		return "redirect";
	}
}