package org.example.service;

import org.example.dao.DeleteDAO;
import org.example.dao.QueryDAO;
import org.example.dao.SaveDAO;
import org.example.model.FileMeta;
import org.example.util.ListUtil;

import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private SaveDAO saveDAO = new SaveDAO();
    private DeleteDAO deleteDAO = new DeleteDAO();
    private QueryDAO queryDAO = new QueryDAO();
    //文件保存
    public void saveFileList(List<FileMeta> fileList) {
        saveDAO.save(fileList);
    }
    //文件删除
    public void deleteFileList(List<FileMeta> fileList){
        /*List<Integer> idList = new ArrayList<>();
        * for(FileMeta file : fileList){
        *   idList.add(file.getId());
        * }*/
        List<Integer> idList = fileList.stream().map(FileMeta::getId).collect(Collectors.toList());
        deleteDAO.delete(idList);
    }
    //文件查询
    public List<FileMeta> query(String keyword){
        return queryDAO.query(keyword);
    }
    //文件对比
    public void service(String path,List<FileMeta> scanList){
        List<FileMeta> queryList = queryDAO.queryByPath(path);
        //从文件系统中扫描出来的没有，但是数据库中有的进行删除
        List<FileMeta>  deleteList = ListUtil.differenceSet(queryList,scanList);
        deleteFileList(deleteList);
        //从文件系统中扫描出来有的，但是数据库中没有的进行保存
        List<FileMeta> saveList = ListUtil.differenceSet(scanList,queryList);
        saveFileList(saveList);
    }
}
