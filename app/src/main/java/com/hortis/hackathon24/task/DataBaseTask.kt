package com.hortis.hackathon24.task

import android.content.Context
import android.os.AsyncTask
import androidx.room.Entity
import androidx.room.Room
import com.hortis.hackathon24.dao.UsuarioDAO
import com.hortis.hackathon24.database.AppDatabase
import com.hortis.hackathon24.entity.Usuario


class DataBaseTask : AsyncTask<Entity, Int, Long>() {

    private var mContext: Context? = null

    fun MyCustomTask(context: Context?) {
        mContext = context
    }

    private var listOfUsuario = mutableListOf<Usuario>()

    override fun doInBackground(vararg params: Entity?): Long {
        val db = Room.databaseBuilder(
            mContext!!,
            AppDatabase::class.java, "hortis"
        ).fallbackToDestructiveMigration()
            .build()

        val usuarioDAO: UsuarioDAO = db.usuarioDAO()

        usuarioDAO.insertAll(Usuario(1, "nome1"), Usuario(2, "nome2"))

//        val anuncioDao: AnuncioDAO = db.anuncioDAO()
//
//        anuncioDao.insertAll(
//            Anuncio(
//                1, "Carambola", 5, "carambola_foreground", "01-02-2024", "01-05-2024",
//                43F, 1, null, null, null, null
//            )
//        )
        listOfUsuario.addAll(usuarioDAO.getAll())
        return 0
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Long?) {
       this.listOfUsuario
    }
}