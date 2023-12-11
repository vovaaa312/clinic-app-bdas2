package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.request.ChangeRoleRequest;
import com.clinicappbdas2.model.security.User;
import com.clinicappbdas2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @CrossOrigin
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

//    @GetMapping("/{login}")
//    public ResponseEntity<User> getByLogin(@PathVariable String login) {
//        return ResponseEntity.ok(userService.getUserByLogin(login));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.create(user);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return ResponseEntity.ok(userService.updateUser(id, user));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/changerole")
    public void changeUserRole(@RequestBody ChangeRoleRequest request) {
        userService.changeUserRole(request.getUserId(),request.getRoleName());
//        return ResponseEntity.ok(request);
    }

}
