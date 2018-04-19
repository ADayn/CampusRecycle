package campusRecycle.formatters;

import campusRecycle.dao.CategoryRepository;
import campusRecycle.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category parse(String s, Locale locale) throws ParseException {
        Long id = Long.parseLong(s);
        String parseErrorMessage = "Could not parse long int from: '" + s + "'";
        return categoryRepository
                .findById(id)
                .orElseThrow(() ->
                        new ParseException(parseErrorMessage, 0));
    }

    @Override
    public String print(Category category, Locale locale) {
        return category.getId().toString();
    }
}
