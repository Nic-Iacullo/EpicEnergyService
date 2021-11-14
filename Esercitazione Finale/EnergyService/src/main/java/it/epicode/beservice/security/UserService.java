package it.epicode.beservice.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.epicode.beservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	public List<User> findAllUser(){
		return userRepository.findAll();
		
	}
	public Optional<User> findUserById(Long id){
		return userRepository.findById(id);
	}
	public User getById (Long Id) {
        return userRepository.getById(Id);
    }
	
	public Page<User> myFindAllUsersPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
	public Page<User> myFindAllUsersPageSize(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<User> pagedResult = userRepository.findAll(paging);
        if(pagedResult.hasContent()) {
      return pagedResult;
      } else {
          return null;
      }
        
    }
	// Paginazione e Ordinamento
    public List<User> myFindAllUsersPageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<User> pagedResult = userRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
 // Ordinamento
    public List<User> myFindAllUsersSorted() {
        return userRepository.findByOrderByNomeAsc();
    }
}
