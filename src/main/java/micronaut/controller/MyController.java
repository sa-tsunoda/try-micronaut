package micronaut.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import micronaut.response.PersonalDataReturn;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;

@Controller("/my")
public class MyController {

	Map<Integer, PersonalDataReturn> inMemoryDatastore = new ConcurrentHashMap<>();

    @Get("/personal-data/{id}")
    public HttpResponse<PersonalDataReturn> index(@PathVariable Integer id) {
        return HttpResponse.created(inMemoryDatastore.get(id));
    }
    
    @Get("/personal-data")
    public MutableHttpResponse<Collection<PersonalDataReturn>> index() {
        return HttpResponse.created(inMemoryDatastore.values());
    }
    
    @Post("/personal-data")
    public HttpResponse<PersonalDataReturn> save(@Body PersonalDataBody body) {
    	Integer id = inMemoryDatastore.size() + 1;
    	PersonalDataReturn response = new PersonalDataReturn(id,body.sei,body.mei);
    	inMemoryDatastore.put(id, response);
        return HttpResponse.created(response);
    }
}