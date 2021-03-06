package com.example.administrador.curso4_tarea3_1.restApi;

import com.example.administrador.curso4_tarea3_1.restApi.model.MascotaResponse;
import com.example.administrador.curso4_tarea3_1.restApi.model.PerfilResponse;
import com.example.administrador.curso4_tarea3_1.restApi.model.UsuarioResponse;

import javax.mail.BodyPart;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by administrador on 19/06/17.
 */

// Interface que genera las peticiones a la api
public interface EndpointsApi {
    //https://api.instagram.com/v1/users/5623708812/media/recent/?access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4
    @GET("users/{id}/media/recent/")//Peticion GET a la api de instagram que va a ser usada por el metodo seguido
    Call<MascotaResponse> getRecentMedia(@Path("id") String id, @Query("access_token") String token); //Retrofit necesita usar la clase Call

    /* GET PARA BUSCAR LOS USUARIOS POR NOMBRE, a partir de ahi podemos obtener el id y luego hacer mas consultas
    https://api.instagram.com/v1/users/search?q=supermascota5&access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4   */
    @GET("users/search") //
    Call<PerfilResponse> getPerfil(@Query("q") String usuario, @Query("access_token") String token);


    @FormUrlEncoded
    @PUT(ConstantesRestApi.KEY_POST_REGISTRAR_USUARIO)
    Call<UsuarioResponse> registrarUsuario(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);
}
