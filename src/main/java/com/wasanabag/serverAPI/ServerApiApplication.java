package com.wasanabag.serverAPI;

import com.wasanabag.serverAPI.model.Item;
import com.wasanabag.serverAPI.repository.ItemRepository;
import com.wasanabag.serverAPI.types.ItemCategory;
import com.wasanabag.serverAPI.types.ItemSize;
import com.wasanabag.serverAPI.types.TimeAt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ServerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ItemRepository itemRepository,
							 MongoTemplate mongoTemplate) {
		return args -> {
//			Student stu = new Student("Buddhi Malinda", "PE/2", "buddhimalinda66@gmail.com", "123456", Gender.MALE);
//
//			// studentRepository.insert(stu);
//			// studentRepository.findStudentByEmail(stu.getEmail()).ifPresentOrElse(s -> {
//			// System.out.println("User already exists");
//			// }, () -> {
//			// System.out.println("Inserting user" + stu.getName());
//			// studentRepository.insert(stu);
//			// });
//
//			Subject subject = new Subject("COST 31022", "COST31022", 2, "B.M.D bla bala", true, false);
//			// subjectRepository.findSubjectBySubjectCode(subject.getSubjectCode()).ifPresentOrElse(s
//			// -> {
//			// System.out.println("User already exists");
//			// }, () -> {
//			// System.out.println("Inserting user" + subject.getSubjectName());
//			// });
//			// subjectRepository.insert(subject);
//			// dEventRepository.insert(doorlockevent);
//			GPAValue gpaValue = new GPAValue('A', 4.0);
//			// gpaValueRepository.insert(gpaValue);Item
//			User user = new User(
//					"100",
//					"Buddhi",
//					"Malinda",
//					"CLERK_USER_EMAIL",
//					"buddhimalinda66@gmail.com",
//					Role.ADMIN
//			);
//			userRepository.insert(user);

			Item item = new Item(
					"101",
					"Bag",
					"Bag",
					ItemCategory.BAG_SCHOOL,
					new String[]{"Bag"},
					new String[]{"Bag"},
					100,
					new ItemSize(
							200,300,400,500, new String[]{"mm", "mm", "mm", "Kg"},45, 'l'
					),
					"Bag",
					new TimeAt(
							new Date().getTime() + "", new Date().getDate()+"", "ADMIN"
					),
					List.of(new TimeAt(
							new Date().getTime()+"", new Date().getDate() +"", "ADMIN"
					))
			);
//			itemRepository.insert(item);
		};
	}
}
