
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		InputReader scan = new InputReader();
		StringBuilder result = new StringBuilder();
		int n = scan.nextInt();
		while (n-- > 0) {
			Bishop a = new Bishop(scan.nextChar(), scan.nextInt());
			Bishop b = new Bishop(scan.nextChar(), scan.nextInt());

			if (a.row == b.row && a.column == b.column) {
				result.append("0 ").append(a.toString()).append("\n");
			} else {
				boolean found = false;
				for (int column = 'A'; column <= 'H'; column++) {
					for (int row = 1; row <= 8; row++) {
						if (Math.abs(column - a.column) == Math.abs(row - a.row)
								&& Math.abs(column - b.column) == Math.abs(row - b.row)) {
							found = true;
							Bishop c = new Bishop((char) column, row);
							result.append((column == a.column && row == a.row || column == b.column && row == b.row)
									? "1 " + a.toString() + " " + b.toString()
									: "2 " + a.toString() + " " + c.toString() + " " + b.toString()).append("\n");
							break;
						}
					}
					if (found) {
						break;
					}
				}
				if (!found) {
					result.append("Impossible\n");
				}
			}
		}

		System.out.println(result);
	}

	static class Bishop {

		char column;
		int row;

		public Bishop(char column, int row) {
			this.column = column;
			this.row = row;
		}

		@Override
		public String toString() {
			return column + " " + row;
		}

	}

	static class InputReader {

		InputStream is = System.in;
		byte[] inbuf = new byte[1 << 23];
		int lenbuf = 0, ptrbuf = 0;

		public InputReader() throws IOException {
			lenbuf = is.read(inbuf);
		}

		public int readByte() {

			if (ptrbuf >= lenbuf) {
				return -1;
			}

			return inbuf[ptrbuf++];
		}

		public boolean hasNext() {
			int t = skip();

			if (t == -1) {
				return false;
			}
			ptrbuf--;
			return true;
		}

		public boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}

		public int skip() {
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char nextChar() {
			return (char) skip();
		}

		public String next() {
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b))) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}

		public char[] ns(int n) {
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b))) {
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}

		public char[][] nm(int n, int m) {
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++) {
				map[i] = ns(m);
			}
			return map;
		}

		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public int nextInt() {
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

		public long nextLong() {
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') {
				minus = true;
				b = readByte();
			}

			while (true) {
				if (b >= '0' && b <= '9') {
					num = num * 10 + (b - '0');
				} else {
					return minus ? -num : num;
				}
				b = readByte();
			}
		}

	}
}
