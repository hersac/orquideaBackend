package com.hersac.orquidea.Services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hersac.orquidea.Models.User;
import com.hersac.orquidea.Repositories.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// Get
	public List<User> userList() {
		return userRepository.findAll();
	}

	public User userFindById(Long id) {

		return userRepository.findById(id).orElse(null);
	}

	// Post
	public User userAdd(User info) {

		try {
			Date fecha = new Date();
			SimpleDateFormat fechaFormateada = new SimpleDateFormat("ddMMyyyy");
			String rutaArchivo = "src/main/resources/usersSources/" + info.getUserLastName() + " " + info.getUserName()
					+ "/";

			File directorio = new File(rutaArchivo);
			if (!directorio.exists()) {
				directorio.mkdirs();
			}

			String archivoFinal = rutaArchivo + fechaFormateada.format(fecha) + info.getUserName() + ".png";

			byte[] bytes = Files.readAllBytes(Paths.get(info.getUserImageProfile()));
			FileOutputStream buscarRuta = new FileOutputStream(archivoFinal);
			BufferedOutputStream escribirArchivo = new BufferedOutputStream(buscarRuta);
			escribirArchivo.write(bytes);
			escribirArchivo.close();

			info.setUserImageProfile(archivoFinal);
		} catch (Exception e) {
			System.out.println("No se escribio el archivo de imagen: " + e);
		}

		return userRepository.save(info);
	}

	public User userValidation(User infoUsuario, final HttpServletResponse response) throws IOException {

		User usuarioActual = userRepository.findByEmailUser(infoUsuario.getUserEmail());

		if (usuarioActual != null && usuarioActual.getUserPasswd().equals(infoUsuario.getUserPasswd())) {
			usuarioActual.setUserPasswd("");
			return usuarioActual;
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return null;
		}
	}

	// Put
	public User userUpdate(Long id, User info) {
		User newUser = userRepository.findById(id).orElse(null);

		try {
			Date fecha = new Date();
			SimpleDateFormat fechaFormateada = new SimpleDateFormat("ddMMyyyy");
			String rutaArchivo = "src/main/resources/usersSources/" + info.getUserLastName() + " " + info.getUserName()
					+ "/";

			File directorio = new File(rutaArchivo);
			if (!directorio.exists()) {
				directorio.mkdirs();
			}

			String archivoFinal = rutaArchivo + fechaFormateada.format(fecha) + info.getUserName() + ".png";

			byte[] bytes = Files.readAllBytes(Paths.get(info.getUserImageProfile()));
			FileOutputStream buscarRuta = new FileOutputStream(archivoFinal);
			BufferedOutputStream escribirArchivo = new BufferedOutputStream(buscarRuta);
			escribirArchivo.write(bytes);
			escribirArchivo.close();

			info.setUserImageProfile(archivoFinal);

			newUser.setUserName(info.getUserName());
			newUser.setUserLastName(info.getUserLastName());
			newUser.setUserBirthday(info.getUserBirthday());
			newUser.setUserEmail(info.getUserEmail());
			newUser.setUserPasswd(info.getUserPasswd());
			newUser.setUserTel(info.getUserTel());
			newUser.setUserCountry(info.getUserCountry());
			newUser.setUserState(info.getUserState());
			newUser.setUserCity(info.getUserCity());
			newUser.setUserImageProfile(info.getUserImageProfile());
		} catch (Exception e) {
			System.out.println("No se escribio el archivo de imagen: " + e);
		}

		User userUpdate = userRepository.save(newUser);
		return userUpdate;
	}

	// Delete
	public ResponseEntity<?> userDelete(Long id) {
		User user = userRepository.findById(id).orElse(null);
		userRepository.delete(user);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> deleteAll() {
		userRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

}