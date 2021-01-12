/*
 * ��� ��� ������ ����� � �������� ����� � ���� ������� �������. ������ ������� �������� ����� ���� � ��������� ����:

����: �����

����� ����� ��������� ����� �������.

�������� �����, ������� ����� ������������ ������� �� �����, ��������������� �� � ���������� ��������� � ���� �������� ������ (��. ������). ������ ������ ��������������� � ��������� ����:

����:
i) �����
j) �����2
...
==������� ������==

i � j -- ������ ����� � ��������. ���������� ������� ���������� � �������, �������� ������ ������� � ������������ � �������� �����. �������� ����� ����� �������� �����������, �������� ����� � ����� ������ �� �����������.

�������, ��� ��� ��������� ��������� �������� ����� � 50 000 ����� ��� 10 ����� � ��������������, ������������ ������ �������������� ������� ����� ����� �� ����������� �� �������.

�������� �������� ��� �� ��������� �������:
��� ��������� ����� ����������� � ������ ����� ������ ����, � ��� ����� � ����������;
�������� ����� ���� ����� ���� ��������� �������� ������ ���� (��������, "����" � "���� �����");
����, � ������� ��� ������, ���� ������ �������������� � �������� �����;
� �������� �������� ������ ���� ������������ ������ '\n' (������� ������ � ����� UNIX);
������ �����������, �� ���������� ������ �������� � ����� �����.

������ ����� 1:
roles:
����������
����� ���������
������� ����������
���� �����
textLines:
����������: � ��������� ���, �������, � ���, ����� �������� ��� ������������� ��������: � ��� ���� �������.
����� ���������: ��� �������?
������� ����������: ��� �������?
����������: ������� �� ����������, ���������. � ��� � ��������� ������������.
����� ���������: ��� �� ��!
������� ����������: ��� �� ���� ������, ��� �����!
���� �����: ������� ����! ��� � � ��������� ������������!
������ ������ 1:
����������:
1) � ��������� ���, �������, � ���, ����� �������� ��� ������������� ��������: � ��� ���� �������.
4) ������� �� ����������, ���������. � ��� � ��������� ������������.

����� ���������:
2) ��� �������?
5) ��� �� ��!

������� ����������:
3) ��� �������?
6) ��� �� ���� ������, ��� �����!

���� �����:
7) ������� ����! ��� � � ��������� ������������!


����������:
1. ����� ������ ���� ���������.
2. ����� ������ ��������� �� ���� ��� ������� �����.
3. ����� ������ ���������� ������.
4. �������������� ������ ������ ��������������� �c�����.
5. ���������� ������������ StringBuilder 

 */
package pyesa01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String[] roles = load("D:\\programming\\roles.txt");
		String[] textLines = load("D:\\programming\\text.txt");
		System.out.println(createAnswer(roles, textLines));
	}
	
	public static String createAnswer(String[] roles, String[] textLines) {
		StringBuilder builder = new StringBuilder();
		for (String role : roles) {
			builder.append(createOneAnswer(role, textLines));
		}
		return builder.toString();
	}
	
	public static String createOneAnswer(String role, String[] textLines) {
		StringBuilder builder = new StringBuilder();
		builder.append(role + ":\n");
		for (int i = 0; i < textLines.length; i++) {
			if (textLines[i].startsWith(role + ":")) {
				builder.append((i + 1) + ")" + textLines[i].substring(role.length() + 2) + "\n");
			}
		}
		return builder.toString();
	}

	public static String[] load(String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list.toArray(new String[0]);
    }
	
}
