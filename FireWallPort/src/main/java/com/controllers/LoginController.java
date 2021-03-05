

  package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController implements ErrorController
  {
	
	
	@GetMapping("/default")
	public String defaultUrl(HttpServletRequest request)
	{
		String res=null;
		if(request.isUserInRole("USER"))
		{
			res="redirect:/customer/viewVms";
		}
		else if(request.isUserInRole("ADMIN"))
		{
			res="redirect:/admin/adminHome";
		}
		else if(request.isUserInRole("EMP"))
		{
			res="redirect:/employee/ticketRequest";
		}
		else if(request.isUserInRole("DCTEAM"))
		{
			res="redirect:/dcteam/home";
		}
		return res;
	}
	
	
	  @GetMapping("/login")
		public String login()
		{
			return "index";
		}
	  @GetMapping("/deniedPage")
	  public String deniedPage()
	  {
		  return "deniedPage";
	  }
	  @RequestMapping("/error")
	    public String handleError() {
	        //do something like logging
	        return "error";
	    }

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
  }
  
 /* import java.io.IOException; import java.nio.file.Files; import
 * java.nio.file.Path; import java.nio.file.Paths; import java.text.DateFormat;
 * import java.text.SimpleDateFormat; import java.time.LocalDateTime; import
 * java.time.format.DateTimeFormatter; import java.util.Calendar; import
 * java.util.List; import java.util.Optional;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import org.springframework.util.FileCopyUtils;
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.bean.FileTB; import com.bean.Client; import
 * com.dao.ClientRepository; import com.dao.FileRepository;
 * 
 * @Controller public class LoginController {
 * 
 * @Autowired //ClientRepository clientRepository;
 * 
 * @Autowired FileRepository fileRepository;
 * 
 * @GetMapping("/") public String index() { System.out.println("called"); return
 * "index"; }
 * 
 * @PostMapping("/login") public String login(@RequestParam("username")String
 * userid,@RequestParam("password")String pass,Model model) { String page;
 * if(userid.equals("admin")&&pass.equals("Railtel@123")) {
 * page="redirect:/addClient"; } else { page="index"; model.addAttribute("msg",
 * "Wrong Credentials");
 * 
 * }
 * 
 * return page;
 * 
 * }
 * 
 * @GetMapping("addClient") public String addClient(Model model) { Client
 * client=new Client(); model.addAttribute("client", client); return
 * "addClient"; }
 * 
 * @PostMapping("/saveClient") public String
 * saveCleint(@ModelAttribute("client")Client client,Model model) {
 * 
 * System.out.println(client.getName()); clientRepository.save(client);
 * model.addAttribute("msg", "Saved Successfully!!!"); return "addClient"; }
 * 
 * @GetMapping("/uploadLogs") public String uploadLogs(Model model) {
 * 
 * 
 * List<Client> clients = (List<Client>) clientRepository.findAll();
 * model.addAttribute("clients", clients); return "uploadLogs"; }
 * 
 * @PostMapping("/upload") public String upload(@RequestParam("client")String
 * client,@RequestParam("upload")MultipartFile upload, Model model) {
 * System.out.println(client+upload); FileTB ft=new FileTB(); try {
 * ft.setData(upload.getBytes()); } catch (IOException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * ft.setFileName(upload.getOriginalFilename()); DateTimeFormatter dtf =
 * DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); LocalDateTime now =
 * LocalDateTime.now(); System.out.println(dtf.format(now)); String
 * fileName=upload.getOriginalFilename().toString(); String[] ext =
 * fileName.split(".");
 * 
 * System.out.println(upload.getOriginalFilename()); System.out.println(ext);
 * ft.setFileType(upload.getOriginalFilename()); ft.setDate(dtf.format(now));
 * //ft.setTime(java.time.LocalTime.now().toString()); ft.setClient(client);
 * System.out.println(java.time.LocalTime.now()); fileRepository.save(ft);
 * model.addAttribute("msg", "Uploaded Successfully!!"); return "uploadLogs"; }
 * 
 * @GetMapping("/viewLogs") public String viewLogs(Model model) { List<FileTB>
 * logFiles=(List<FileTB>) fileRepository.findAll();
 * model.addAttribute("logFiles", logFiles); return "viewLogs"; }
 * 
 * @GetMapping("/download/{id}") public String Download(HttpServletResponse
 * response, @PathVariable("id") int id,HttpServletRequest request) {
 * System.out.println("inside download"); FileTB file1 = null;
 * System.out.println(id); Optional<FileTB> f=fileRepository.findById(id);
 * if(f.isPresent()) { file1 = f.get(); }
 * response.setContentType(file1.getFileType());
 * response.setContentLength(file1.getData().length);
 * response.setHeader("Content-Disposition","attachment; filename=\"" +
 * file1.getFileName() +"\"");
 * 
 * try { FileCopyUtils.copy(file1.getData(), response.getOutputStream()); }
 * catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return "viewLogs";
 * 
 * }
 * 
 * @GetMapping("/logout") public String logout(HttpServletRequest request) {
 * HttpSession session = request.getSession(); session.invalidate(); return
 * "redirect:/"; } }
 */