//package campusRecycle.formatters;
//
//import campusRecycle.dao.CategoryRepository;
//import campusRecycle.dao.UserRepository;
//import campusRecycle.model.Category;
//import campusRecycle.model.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//@Component
//public class PersonFormatter implements Formatter<Person> {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public Person parse(String s, Locale locale) throws ParseException {
//        Long id = Long.parseLong(s);
//        String parseErrorMessage = "Could not parse long int from: '" + s + "'";
//        return userRepository
//                .findById(id)
//                .orElseThrow(() ->
//                        new ParseException(parseErrorMessage, 0));
//    }
//
//    @Override
//    public String print(Person person, Locale locale) {
//        return person.getId().toString();
//    }
//}
