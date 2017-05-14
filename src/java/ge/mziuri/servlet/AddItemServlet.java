package ge.mziuri.servlet;

import ge.mziuri.dao.ItemDAO;
import ge.mziuri.dao.ItemDAOImpl;
import ge.mziuri.model.Item;
import ge.mziuri.model.ProdType;
import ge.mziuri.model.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet(name = "UAServlet", urlPatterns = {"/UAServlet"})
public class AddItemServlet extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50000 * 1024;
    private int maxMemSize = 50000 * 1024;
    private File file;

    private String imagePath;

    public void init() {

        filePath = getServletContext().getInitParameter("file-upload");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> table = new HashMap<>();
        List<String> photos = new ArrayList<>();
        try {
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("c:\\temp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            List fileItems = upload.parseRequest(request);
            Iterator i = fileItems.iterator();
            Random random = new Random();
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    String fileName = fi.getName();
                    String extention = FilenameUtils.getExtension(fileName);
                    String imageName = FilenameUtils.removeExtension(fileName);
                    if (fileName.lastIndexOf("\\") >= 0) {
                        fileName = imageName + random.nextInt() + "." + extention;
                        imagePath = fileName;
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        fileName = imageName + random.nextInt() + "." + extention;
                        photos.add(fileName);
                        imagePath = fileName;
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    try {
                        fi.write(file);
                    } catch (Exception ex) {
                    }
                }
            }
            Iterator<FileItem> iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item1 = iter.next();
                if (!item1.getFieldName().equals("file")) {
                    table.put(item1.getFieldName(), item1.getString());
                }
            }
            processRequest(request, response);
        } catch (FileUploadException ex) {
            System.out.println(ex.getMessage());
        }
        String condition = table.get("condition");
        String type = table.get("type");
        String name = table.get("name");
        String description = table.get("description");
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setType(ProdType.valueOf(type));
        item.setPhotoes(photos);
        User user = new User();
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("logedInUserId")) {
                user.setId(Integer.parseInt(cookie.getValue()));
            }
        }
        item.setUser(user);
        switch (type) {
            case "FURNITURE":
                item.setPoint(32);
                break;
            case "TECH":
                item.setPoint(29);
                break;
            case "CAR":
                item.setPoint(52);
                break;
            case "GROUND":
                item.setPoint(61);
                break;
            case "HOUSE":
                item.setPoint(70);
                break;
            case "LITLE_STUFF":
                item.setPoint(8);
                break;
        }
        int con = Integer.parseInt(condition);
        if (con >= 0 && con <= 10) {
            item.setPoint(item.getPoint() + 1);
        } else if (con >= 11 && con <= 20) {
            item.setPoint(item.getPoint() + 4);
        } else if (con >= 21 && con <= 30) {
            item.setPoint(item.getPoint() + 6);
        } else if (con >= 31 && con <= 40) {
            item.setPoint(item.getPoint() + 11);
        } else if (con >= 41 && con <= 50) {
            item.setPoint(item.getPoint() + 15);
        } else if (con >= 51 && con <= 60) {
            item.setPoint(item.getPoint() + 19);
        } else if (con >= 61 && con <= 70) {
            item.setPoint(item.getPoint() + 22);
        } else if (con >= 71 && con <= 80) {
            item.setPoint(item.getPoint() + 27);
        } else if (con >= 81 && con <= 90) {
            item.setPoint(item.getPoint() + 30);
        } else if (con >= 91 && con <= 100) {
            item.setPoint(item.getPoint() + 39);
        }
        ItemDAO itemDAO = new ItemDAOImpl();
        itemDAO.addItem(item);
        RequestDispatcher rd = request.getRequestDispatcher("Spacing.html");
        rd.forward(request, response);
    }
}
