package eu.rtakacs.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;

public class FilesFileAttributeView {

	public static void main(String[] args) throws IOException {
		
		Path file = Paths.get("src", "eu", "rtakacs", "files","FilesFileAttributeView.java").toAbsolutePath();
		
		BasicFileAttributeView attributeViewBasic = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		BasicFileAttributes attrsBasic = attributeViewBasic.readAttributes();
		System.out.format("isRegularFile = %s  creationTime = %s%n", attrsBasic.isRegularFile(), attrsBasic.creationTime());
		
		DosFileAttributeView attributeViewDos = Files.getFileAttributeView(file, DosFileAttributeView.class);
		if(attributeViewDos != null){
			DosFileAttributes attrsDos = attributeViewDos.readAttributes();
			System.out.format("isHidden = %s isReadOnly = %s%n", attrsDos.isHidden(), attrsDos.isReadOnly());
		}
		
		PosixFileAttributeView attributeViewPosix = Files.getFileAttributeView(file, PosixFileAttributeView.class);
		if(attributeViewPosix != null){
			PosixFileAttributes attrs = attributeViewPosix.readAttributes();
			System.out.format("owner.name = %s  permissions = %s%n", attrs.owner().getName(), PosixFilePermissions.toString(attrs.permissions()));
		}
		
		AclFileAttributeView view = Files.getFileAttributeView(file, AclFileAttributeView.class);
	    if (view != null) {
	         List<AclEntry> acl = view.getAcl();
	         AclEntry entry = acl.get(0);
	         System.out.format("principal = %s%npermissions = %s%n", entry.principal(), entry.permissions());
	     }
		
	}

}
